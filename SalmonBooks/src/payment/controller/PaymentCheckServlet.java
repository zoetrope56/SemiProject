package payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import payment.model.service.PaymentService;
import payment.model.vo.Payment;

/**
 * Servlet implementation class PaymentCheckServlet
 */
@WebServlet("/checkpay.do")
public class PaymentCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultCode = request.getParameter("resultCode");
		if(resultCode.equals("Success")) {
			HttpSession httpSession = request.getSession(false); 
			User user =  (User)httpSession.getAttribute("authUser");
			
			
			int point = Integer.parseInt(request.getParameter("point"));
			System.out.println("[checkServlet] "+point);
			
			
			
			String userId = user.getId();
			System.out.println("paymentCheckservlet : " + userId);
			
			//System.out.println(point);
			
			
			Payment p = new Payment();
			p.setUserId(userId);
			p.setPoint(point);
			
			String page = "";
			
			System.out.println("paymentServlet : "+p.getPoint());
			int result = new PaymentService().insertPayment(p);
			
			if(result > 0) {
				 page ="/WEB-INF/views/paycheck.jsp";
				 request.getRequestDispatcher(page).forward(request, response);
			}else {
				request.setAttribute("result", "실패");
				System.out.println("실패");
			}			
		}else {
			System.out.println("실패!");
		}
		// 네이버 페이 후에 결제 성공하고 데이터베이스에 올려주는 부분 ! - 연결 제이에스피에서 확인버튼으로  ,홈으로 가게 만들
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doGet(request, response);
	}

}
