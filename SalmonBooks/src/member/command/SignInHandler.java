package member.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.SignInRequest;
import member.service.SignInService;
import mvc.command.CommandHandler;

public class SignInHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/signinForm.jsp";
	private SignInService signInService = new SignInService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println(req.getContextPath());
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}
		return null;	
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		SignInRequest inReq = new SignInRequest();
		inReq.setId(req.getParameter("id"));
		inReq.setPassword(req.getParameter("password"));
		inReq.setName(req.getParameter("name"));
		inReq.setEmail(req.getParameter("emailFront")+"@"+req.getParameter("emailBack"));
		String year = req.getParameter("year");
		String month = req.getParameter("month");
		String day = req.getParameter("day");	
		String birth = year+month+day;
		System.out.println(birth);
		String tel = req.getParameter("tel1")+req.getParameter("tel2")+req.getParameter("tel3");
		try {
			inReq.setBirth(new SimpleDateFormat("yyyyMMdd").parse(birth));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		inReq.setTel(tel);
		inReq.setConfirmPassword("confirmPassword");
		System.out.println(inReq);
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		inReq.validate(errors);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			signInService.SignIn(inReq);
			return "/WEB-INF/views/signInSuccess.jsp";
		}catch(DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
