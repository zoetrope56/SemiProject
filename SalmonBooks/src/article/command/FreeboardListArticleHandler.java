package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.FreeboardArticlePage;
import article.service.FreeboardListArticleService;
import mvc.command.CommandHandler;

public class FreeboardListArticleHandler implements CommandHandler{
	private FreeboardListArticleService listService = new FreeboardListArticleService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String pageNoVal = req.getParameter("pageNo");
		int pageNo =1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		FreeboardArticlePage articlePage = listService.getArticlePage(pageNo);
		req.setAttribute("articlePage", articlePage);
		System.out.println(articlePage.hasArticles());
		return "/WEB-INF/views/freeboardListArticle.jsp";
	}
}
