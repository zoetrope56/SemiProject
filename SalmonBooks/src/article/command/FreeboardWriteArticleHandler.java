package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.FreeboardWriter;
import article.service.FreeboardWriteArticleService;
import article.service.FreeboardWriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class FreeboardWriteArticleHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/newArticleForm.jsp";
	private FreeboardWriteArticleService writeArticleService = new FreeboardWriteArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		User user = (User)req.getSession(false).getAttribute("authUser");
		FreeboardWriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		int newArticleNo = writeArticleService.write(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);
		try {
			res.sendRedirect("read.do?no="+newArticleNo);
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		return "/WEB-INF/views/readFreeboardArticle.jsp?no="+newArticleNo;
	}
	private FreeboardWriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new FreeboardWriteRequest(new FreeboardWriter(user.getId(), user.getName()), req.getParameter("title"), req.getParameter("content"), req.getParameter("category"));
	}
}
