package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.CommentWriter;
import article.service.FreeboardCommentWriteRequest;
import article.service.FreeboardWriteArticleService;
import article.service.FreeboardWriteCommentService;
import auth.service.User;
import mvc.command.CommandHandler;

public class FreeboardWriteArticleCommentHandler implements CommandHandler{
	private static final String FORM_VIEW = "";
	private FreeboardWriteCommentService commentService = new FreeboardWriteCommentService();
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
		return FORM_VIEW+req.getParameter("no");
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		User user = (User)req.getSession(false).getAttribute("authUser");
		System.out.println("[FreeboardWriteArticleCommentHandler] 확인용 인자 : " + req.getParameter("confirm"));
		System.out.println("content : " + req.getParameter("content") + "no " + req.getParameter("no"));
		FreeboardCommentWriteRequest writeReq = craeteWriteRequest(user, req);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW + req.getParameter("no");
		}
		System.out.println("[FreeboardWriteArticleCommentHandler]����� �츮�� �帧�� ã�Ƽ�");
		int articleNo = commentService.write(writeReq);
		req.setAttribute("no", articleNo);
		try {
			res.sendRedirect("read.do?no="+articleNo);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private FreeboardCommentWriteRequest craeteWriteRequest(User user, HttpServletRequest req) {
		return new FreeboardCommentWriteRequest(new CommentWriter(user.getId(), user.getName()), req.getParameter("content"), Integer.parseInt(req.getParameter("no")));
	}
}
