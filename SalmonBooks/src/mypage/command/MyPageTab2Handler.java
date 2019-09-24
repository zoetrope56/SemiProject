package mypage.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import mvc.command.CommandHandler;
import payment.model.service.PaymentService;
import payment.model.vo.Payment;
import usingpayment.model.service.UsingPaymentService;
import usingpayment.model.vo.UsingPayment;

public class MyPageTab2Handler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/mypage/myPage_2.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		HttpSession httpSession = req.getSession(false); 
		User user =  (User)httpSession.getAttribute("authUser");
		
		ArrayList<UsingPayment> usingpaymentlist = new ArrayList<UsingPayment>();
		ArrayList<UsingPayment> pointlist = new ArrayList<UsingPayment>();
		UsingPaymentService ups = new UsingPaymentService();
		
		usingpaymentlist = ups.select(user.getId());
		//pointlist = 
		
		System.out.println(user.getId());
		
		String page = "";
		
		if(usingpaymentlist != null) {
			page = "WEB-INF/views/mypage/usingpaymentList.jsp";
			req.getSession().setAttribute("list", usingpaymentlist);
			//req.getSession().getAttribute("list");
			
		}else {
			req.setAttribute("result", "실패");
			System.out.println("실패");
		}
		return FORM_VIEW;
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		HttpSession httpSession = req.getSession(false); 
		User user =  (User)httpSession.getAttribute("authUser");
		
		ArrayList<Payment> list = new ArrayList<Payment>();
		ArrayList<UsingPayment> usingpaymentlist =new ArrayList<UsingPayment>();
		
		UsingPaymentService ups = new UsingPaymentService();		
		PaymentService ps = new PaymentService();
		
		list = ps.select(user.getId());
		usingpaymentlist = ups.select(user.getId());
		System.out.println(user.getId());
		
		String page = "";
		
		if(list != null) {
			page = "WEB-INF/views/mypage/paymentList.jsp";
			req.getSession().setAttribute("list", list);
			req.getSession().setAttribute("usingpaymentlist", usingpaymentlist);
			
		}else {
			req.setAttribute("result", "실패");
			System.out.println("실패");
		}
		return FORM_VIEW;
	}

}
