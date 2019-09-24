package mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.model.Member;
import mvc.command.CommandHandler;
import mypage.service.MyPageService;
import payment.model.service.PaymentService;

public class MyPageHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/mypage/myPage_home.jsp";
	private MyPageService myPageService = new MyPageService();
	private PaymentService paymentService = new PaymentService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("get");
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("post");
			return processSubmit(req, res);
		}
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		User user = (User) req.getSession().getAttribute("authUser");
		Member member = myPageService.searchMember(user.getId());
		int userPoint = paymentService.selectUserPoint(member.getUserId());
		
		req.getSession().setAttribute("member", member);
		req.getSession().setAttribute("point", userPoint);

		return FORM_VIEW;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		processSubmit(req, res);
		return FORM_VIEW;
	}

}
