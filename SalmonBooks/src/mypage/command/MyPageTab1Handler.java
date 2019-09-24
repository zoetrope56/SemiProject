package mypage.command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mypage.service.MyPageService;
import member.service.PwdChangeService;
import mvc.command.CommandHandler;


public class MyPageTab1Handler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/mypage/myPage_1.jsp";
	private static final String NULL_SHA512 = "z4PhNX7vuL3xVChQ1m2AB9Yg5AULVxXcg/SpIdNs6c5H0NE8XYXysP+DGNKHfuwvY7kxvUdBeoGlODJ6+SfaPg==";
	private PwdChangeService pwdChaneService = new PwdChangeService();
	private MyPageService myPageService = new MyPageService();

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
		User user = (User)req.getSession().getAttribute("authUser");
		
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		String userEmail = req.getParameter("userEmail");
		String userPhone = req.getParameter("userPhone");
		
		System.out.println("[MyPageTab1Handler] : "+curPwd);
		System.out.println("[MyPageTab1Handler] : "+newPwd);
		System.out.println("[MyPageTab1Handler] : "+userEmail);
		System.out.println("[MyPageTab1Handler] : "+userPhone);
		
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);

		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			if((!curPwd.equals(NULL_SHA512) && !curPwd.isEmpty())&&(!newPwd.equals(NULL_SHA512) && !newPwd.isEmpty())) {
				pwdChaneService.changePwd(user.getId(), curPwd, newPwd);
			}
			if(userEmail!=null && !userEmail.isEmpty()) {
				myPageService.changeEmail(user.getId(), userEmail);
			}
			if(userPhone!=null && !userPhone.isEmpty()) {
				myPageService.changePhone(user.getId(), userPhone);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return FORM_VIEW;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}
