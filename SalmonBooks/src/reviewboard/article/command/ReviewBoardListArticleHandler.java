package reviewboard.article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import reviewboard.article.service.ReviewBoardArticlePage;
import reviewboard.article.service.ReviewBoardListArticleService;

public class ReviewBoardListArticleHandler implements CommandHandler {
	private ReviewBoardListArticleService listService = new ReviewBoardListArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
	String pageNoval =req.getParameter("pageNo");	
	int pageNo = 1;
	if(pageNoval !=null) {
		pageNo = Integer.parseInt(pageNoval);
		
	}
	ReviewBoardArticlePage articlePage = listService.getArticlePage(pageNo);
	req.setAttribute("articlePage", articlePage);
	System.out.println(articlePage.hasArticles());
	return "/WEB-INF/views/reviewBoardListArticle.jsp";
	}


}
