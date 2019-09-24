package srch.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import srch.service.SearchFailException;
import srch.service.SearchService;

public class IdSearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/views/IdAndPwdSearch/idSearchForm.jsp";
	private SearchService searchService = new SearchService();


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


	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String name = trim(req.getParameter("name"));
		String email = trim(req.getParameter("email"));
		String id = null;
		Cookie srchId = null;
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);

		if(name==null || name.isEmpty()) {
			errors.put(name, Boolean.TRUE);
		}
		if(email==null || email.isEmpty()) {
			errors.put(email, Boolean.TRUE);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			id = searchService.idSearch(name, email);
			
			if(id !=null || !id.isEmpty()) {
				req.getSession().setAttribute("srchId", id);
			
			srchId = new Cookie("saveId", id);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			srchId.setMaxAge(24*60*60);
			
			res.addCookie(srchId);
			System.out.println("회원님의 아이디는 "+id+"입니다.");
			return "/WEB-INF/views/IdAndPwdSearch/NewId.jsp";
			}
			else {
				return FORM_VIEW;
			}

		}catch(SearchFailException e) {
			e.printStackTrace();
		}
		return null;
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String trim (String str) {
		return str == null ? null : str.trim();
	}




}
