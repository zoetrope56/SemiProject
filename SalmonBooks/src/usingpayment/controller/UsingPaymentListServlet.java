package usingpayment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import usingpayment.model.service.UsingPaymentService;
import usingpayment.model.vo.UsingPayment;



/**
 * Servlet implementation class UsingPaymentListServlet
 */
@WebServlet("/usingpaymentlist.do")
public class UsingPaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsingPaymentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(false); 
		User user =  (User)httpSession.getAttribute("authUser");
		
		ArrayList<UsingPayment> list = new ArrayList<UsingPayment>();
		
		UsingPaymentService ups = new UsingPaymentService();
		
		list = ups.select(user.getId());
		
		String page = "";
		
		if(list != null) {
			page = "WEB-INF/views/usingpointList.jsp";
			request.setAttribute("list", list);
			
		}else {
			request.setAttribute("result", "실패");
			System.out.println("실패");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
