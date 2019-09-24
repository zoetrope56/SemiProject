package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.CommentWriter;
import article.service.FreeboardCommentPage;
import article.service.FreeboardCommentWriteRequest;
import article.service.FreeboardListCommentService;
import article.service.FreeboardWriteCommentService;
import auth.service.User;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class FreeboardWriteCommentServlet
 */
public class FreeboardWriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreeboardWriteCommentService commentService = new FreeboardWriteCommentService();
	private FreeboardListCommentService commentListService = new FreeboardListCommentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeboardWriteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);		
		User user = (User)req.getSession(false).getAttribute("authUser");
		FreeboardCommentWriteRequest writeReq = craeteWriteRequest(user, req);
		writeReq.validate(errors);
		commentService.write(writeReq);
		FreeboardCommentPage fcp = commentListService.getCommentPage(Integer.parseInt(req.getParameter("count")), Integer.parseInt(req.getParameter("no")));
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
	private FreeboardCommentWriteRequest craeteWriteRequest(User user, HttpServletRequest req) {
		return new FreeboardCommentWriteRequest(new CommentWriter(user.getId(), user.getName()), req.getParameter("content"), Integer.parseInt(req.getParameter("no")));
	}
}
