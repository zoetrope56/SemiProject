package reviewboard.article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import auth.service.User;
import mvc.command.CommandHandler;
import reviewboard.article.model.ReviewBoardWriter;
import reviewboard.article.service.ReviewBoardWriteArticleService;
import reviewboard.article.service.ReviewBoardWriteRequest;

public class ReviewboardWriteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/views/reviewNewArticleForm.jsp";
	private ReviewBoardWriteArticleService writeArticleService = new ReviewBoardWriteArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,res);

		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);

		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;	
			}

		}
		private String processForm(HttpServletRequest req, HttpServletResponse res){
			return FORM_VIEW;
		}
		private String processSubmit(HttpServletRequest req, HttpServletResponse res){
			Map<String,Boolean> errors = new HashMap<>();	
			req.setAttribute("errors",errors);

			User user = (User)req.getSession(false).getAttribute("authUser");
			ReviewBoardWriteRequest writeReq = createWriteRequest(user, req);
			writeReq.validate(errors);

			if(!errors.isEmpty()) {
				return FORM_VIEW;	
			}
			int newArticleNo = writeArticleService.write(writeReq);
			req.setAttribute("newArticleNo",newArticleNo);
			try {
				res.sendRedirect("read.do?no="+newArticleNo);
				return null;
			}catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		private ReviewBoardWriteRequest createWriteRequest(User user, HttpServletRequest req) {
			return new ReviewBoardWriteRequest(new ReviewBoardWriter(user.getId(), user.getName()), req.getParameter("title"), req.getParameter("content"), req.getParameter("category"));
		}
	}

