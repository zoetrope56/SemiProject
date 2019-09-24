package article.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleRecommendService;
import net.sf.json.JSONObject;

public class RecommendUpdateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleRecommendService recommendService = new ArticleRecommendService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(req.getParameter("no"));
		System.out.println("[ArticleRecommendHandler] no : " + no);
		int increaseCount = recommendService.increaseRecommend(no);
		//User user = (User)req.getSession(false).getAttribute("user");
		JSONObject obj = new JSONObject();
		obj.put("result", increaseCount);
		res.setContentType("application/x-json; charset=UTF-8");
		res.getWriter().print(obj);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}

