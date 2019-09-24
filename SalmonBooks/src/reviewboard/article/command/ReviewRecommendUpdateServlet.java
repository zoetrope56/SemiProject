package reviewboard.article.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONObject;
import reviewboard.article.service.ReviewBoardArticleRecommendService;


public class ReviewRecommendUpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ReviewBoardArticleRecommendService recommendService = new ReviewBoardArticleRecommendService();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
						 
		int no = Integer.parseInt(req.getParameter("no"));
		System.out.println("[ArticleRecommendHandler] no : "+ no);
		int increaseCount = recommendService.increaseRecommend(no);
		
		
		JSONObject obj = new JSONObject();
		obj.put("result", increaseCount);
		res.setContentType("application/x-json; charset=UTF-8");
		res.getWriter().print(obj);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req,res);
	}
	
}
	