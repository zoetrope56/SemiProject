package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/loginForm.jsp";
	private LoginService loginService = new LoginService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Cookie saveId = null;
		
		String id =trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		String saveIdCheck = req.getParameter("saveId");
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		if(id == null || id.isEmpty()) {
			errors.put("id", Boolean.TRUE);
		}
		if(password == null || password.isEmpty()) {
			errors.put("password", Boolean.TRUE);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			if(saveIdCheck != null && saveIdCheck.trim().equals("on")) {		// 아이디 저장
				saveId = new Cookie("saveId", id);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
				saveId.setMaxAge(24*60*60);
				res.addCookie(saveId);
			} else {
				saveId = new Cookie("saveId", null);
				saveId.setMaxAge(0);
				res.addCookie(saveId);
			}

			User user = loginService.login(id, password);
			req.getSession().setAttribute("authUser", user);
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			return null;
		}catch(LoginFailException e) {
			errors.put("idOrPwdNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	private String trim (String str) {
		return str == null ? null : str.trim();
	}
}
