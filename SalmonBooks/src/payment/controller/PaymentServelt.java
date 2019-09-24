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
 * Servlet implementation class PaymentServelt
 */
@WebServlet("/payment.do")
public class PaymentServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServelt()                                                                                                                                                                                   {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/payment.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//여기는 포인트 체크하고 값가지고 네이버 페이로 넘겨주는 부분 
		
		
		
		
		
//		HttpSession httpSession = request.getSession(false); 
//		User user =  (User)httpSession.getAttribute("authUser");
//		
//		String userId = user.getId();
//		int Point = Integer.parseInt(request.getParameter("point"));
//		
//		
//		System.out.println(Point);
//		
//		
//		Payment p = new Payment();
//		p.setUserId(userId);
//		p.setPoint(Point);
//		
//		
//		System.out.println("paymentServlet : "+p.getPoint());
//		int result = new PaymentService().insertPayment(p);
//		
//		if(result > 0) {
//			response.sendRedirect("updatePayment");
//			System.out.println("성공");
//			
//		}else {
//			request.setAttribute("result", "실패");
//			System.out.println("실패");
//		}
		
	}

}