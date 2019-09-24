package reviewboard.article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.CommentWriter;
import auth.service.User;
import net.sf.json.JSONObject;
import reviewboard.article.service.ReviewBoardCommentPage;
import reviewboard.article.service.ReviewBoardCommentWriteRequest;
import reviewboard.article.service.ReviewBoardListCommentService;
import reviewboard.article.service.ReviewBoardWriteCommentService;

/**
 * Servlet implementation class ReviewBoardWriteCommentServlet
 */

public class ReviewBoardWriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewBoardWriteCommentService commentService = new ReviewBoardWriteCommentService();   
    private ReviewBoardListCommentService commentListService = new ReviewBoardListCommentService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBoardWriteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		User user = (User)req.getSession(false).getAttribute("authUser");
		System.out.println("홍은영 영어사전 : parttern 파턴  uer 유저");
		ReviewBoardCommentWriteRequest writeReq = craeteWriteRequest(user,req);
		writeReq.validate(errors);
		commentService.write(writeReq);
		ReviewBoardCommentPage fcp = commentListService.getCommentPage(Integer.parseInt(req.getParameter("count")), Integer.parseInt(req.getParameter("no")));
		JSONObject obj = new JSONObject();
		obj.put("result", fcp);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private ReviewBoardCommentWriteRequest craeteWriteRequest(User user, HttpServletRequest req) {
		System.out.println("user "+user.toString() + " " + req.getParameter("content") + " " + req.getParameter("no"));
		System.out.println("홍은영 찝알바보");
		return new ReviewBoardCommentWriteRequest(new CommentWriter(user.getId(), user.getName()), req.getParameter("content"), Integer.parseInt(req.getParameter("no")));
			
		}
	}
	


