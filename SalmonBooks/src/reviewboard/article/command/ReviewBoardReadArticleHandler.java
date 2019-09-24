package reviewboard.article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleNotFoundException;
import mvc.command.CommandHandler;
import reviewboard.article.model.ReviewBoardArticleData;
import reviewboard.article.service.ReviewBoardReadArticleService;

public class ReviewBoardReadArticleHandler implements CommandHandler{
	ReviewBoardReadArticleService readService = new ReviewBoardReadArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("들어오긴 함?");
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			ReviewBoardArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);
			return "/WEB-INF/views/readReviewBoardArticle.jsp";

		}catch(ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article",e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}


	}
}
