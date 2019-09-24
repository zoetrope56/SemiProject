package reviewboard.article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.CommentWriter;
import auth.service.User;
import mvc.command.CommandHandler;
import reviewboard.article.service.ReviewBoardCommentWriteRequest;
import reviewboard.article.service.ReviewBoardWriteCommentService;

public class ReviewBoardWriteArticleCommentHandler implements CommandHandler{
	private static final String FORM_VIEW ="read.do?do";
	private ReviewBoardWriteCommentService commentService = new ReviewBoardWriteCommentService();
	@Override

	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	private String processForm (HttpServletRequest req,HttpServletResponse res) {
		return FORM_VIEW+req.getParameter("no");

	}
	private String processSubmit (HttpServletRequest req,HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User)req.getSession(false).getAttribute("authUser");
		ReviewBoardCommentWriteRequest  writeReq = craeteWriteRequest(user, req);

		writeReq.validate(errors);

		if(!errors.isEmpty()) {
			return FORM_VIEW + req.getParameter("no");
		}
		int articleNo = commentService.write(writeReq);
		req.setAttribute("no", articleNo);
		try {
			res.sendRedirect("read.do?no="+articleNo);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private ReviewBoardCommentWriteRequest craeteWriteRequest(User user, HttpServletRequest req) {
		return new ReviewBoardCommentWriteRequest(new CommentWriter(user.getId(), user.getName()), req.getParameter("content"), Integer.parseInt(req.getParameter("no")));

	}

}


