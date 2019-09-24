package novel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import novel.service.NovelService;
import novel.vo.NovelInfo;
import novel.vo.PageInfo;

/**
 * Servlet implementation class PayNovelGenreListServlet
 */
@WebServlet("/payGenreList.do")
public class PayNovelGenreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayNovelGenreListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NovelInfo> list =null;
		ArrayList<NovelInfo> top3list = null;
		NovelService ns = new NovelService();

		int startPage;// 한 번에 표시할 페이지들 중 가장 앞의 페이지
		int endPage;// 한 번에 표시할 페이지들 중 가장 뒤의 페이지
		int maxPage;// 전체 페이지의 가장 마지막 페이지
		int currentPage;// 사용자가 위치한 현재 페이지
		int limit;// 한 페이지당 보여줄 게시글 수
		
		currentPage = 1; //첫페이지 1로 초기화
		limit = 9;// 글 개수 및 페이지 수  제한
		
		String free = request.getParameter("FREE");
		String complate = request.getParameter("COMPLATE");
		String genre = request.getParameter("GENRE");
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		int listCount = ns.getListCount(free,complate, genre);
		
		
		maxPage = (int) ((double)listCount / limit + 0.9);
		startPage = ((int)((double)currentPage/10 + 0.9)-1)*limit +1;
		endPage = startPage + 9;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = ns.selectNovelList(currentPage, limit , free, complate, genre);
		top3list = ns.selectTop3List(free, complate, genre);
		String page = "";
		page = "/WEB-INF/views/novelPage/PayNovelList.jsp";
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		request.setAttribute("list", list);
		request.setAttribute("top3list", top3list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
