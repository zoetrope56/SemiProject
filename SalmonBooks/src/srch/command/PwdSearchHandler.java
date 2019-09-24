package srch.command;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.service.PwdChangeService;
import mvc.command.CommandHandler;
import srch.service.SearchFailException;
import srch.service.SearchService;

public class PwdSearchHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/IdAndPwdSearch/pwdSearchForm.jsp";
	private SearchService searchService = new SearchService();
	private PwdChangeService changePwdSvc = new PwdChangeService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = trim(req.getParameter("name"));
		String email = trim(req.getParameter("email"));
		String phone = trim(req.getParameter("phone"));
		String password=null, id=null;
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		if(name==null || name.isEmpty()) {
			errors.put(name, Boolean.TRUE);
		}
		if(email==null || email.isEmpty()) {
			errors.put(email, Boolean.TRUE);
		}
		if(phone==null || phone.isEmpty()) {
			errors.put(phone, Boolean.TRUE);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			id = searchService.idSearch(name, email);
			password = searchService.pwdSearch(name, email, phone);
			String newPwd = createPwd();
			
			changePwdSvc.changePwd(id, password, getSHA512(newPwd));
			
			req.getSession().setAttribute("password", newPwd);
			System.out.println("[PwdSearchHandler] : "+newPwd);
			
		}catch(SearchFailException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/IdAndPwdSearch/NewPwd.jsp";
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String trim (String str) {
		return str == null ? null : str.trim();
	}
	private static String getSHA512(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);

			return Base64.getEncoder().encodeToString(md.digest());

		} catch (NoSuchAlgorithmException e) {

			System.out.println("암호화 에러 발생!");
			e.printStackTrace();
			return null;
		}
	}

	public static String createPwd() {
		StringBuffer temp = new StringBuffer();

		Random rnd = new Random();
		
		for (int i = 0; i < 10; i++) {


			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}        
		}
		System.out.println("[PwdChangeHandler] : "+temp.toString());
		return temp.toString();
	}
}
