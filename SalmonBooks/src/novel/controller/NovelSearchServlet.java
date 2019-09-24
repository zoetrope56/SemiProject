package novel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.NotIncreaseRecommendCountException;
import novel.service.NovelService;
import novel.vo.NovelInfo;

/**
 * Servlet implementation class NovelSearchServlet
 */
@WebServlet("/novelsearch.do")
public class NovelSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
//		String free = request.getParameter("free");
		System.out.println("검색 잘들어갔나"+keyword);
//		System.out.println("검색 잘들어갔나"+free);
		ArrayList<NovelInfo> list = new ArrayList<>();
		
		NovelService ns = new NovelService();
		
		list = ns.searchNovel(keyword);
		
		String page = "/WEB-INF/views/novelPage/SearchNovelList.jsp";
		
		request.setAttribute("list", list);
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
