package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.FreeboardArticleData;
import article.service.ArticleContentNotFoundException;
import article.service.ArticleNotFoundException;
import article.service.FreeboardReadArticleService;
import mvc.command.CommandHandler;

public class FreeboardReadArticleHandler implements CommandHandler{
	FreeboardReadArticleService readService = new FreeboardReadArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			FreeboardArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);
			return "/WEB-INF/views/readFreeboardArticle.jsp";
		}catch(ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
