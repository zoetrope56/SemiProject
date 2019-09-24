package novel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import novel.service.NovelService;
import novel.vo.DetailNovel;
import novel.vo.NovelInfo;
import novel.vo.PageInfo;

/**
 * Servlet implementation class NovelSelectOne
 */
@WebServlet("/selectOne.do")
public class NovelSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    private NovelService ns = new NovelService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NovelService ns = new NovelService();   
		ArrayList<DetailNovel> dList = null;
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		NovelInfo ni = ns.selectOne(nno);
		// 한 번에 표시할 페이지들 중 가장 앞의 페이지
		int startPage;
		
		// 한 번에 표시할 페이지들 중 가장 뒤의 페이지
		int endPage;
		
		// 전체 페이지의 가장 마지막 페이지
		int maxPage;
		
		// 사용자가 위치한 현재 페이지
		int currentPage;
		
		// 총 페이지 수(한 페이지당 보여줄 게시글 수)
		int limit;
		
		// 처음 접속 시 페이지는 1페이지 부터 시작한다.
		currentPage = 1;
		
		// 글 개수 및 페이지 수 10개로 제한하기
		limit = 10;
		
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		}
		
		int listCount = ns.getDetailListCount(nno);
		
		System.out.println("listcount : " + listCount);
		
		maxPage = (int) ((double)listCount / limit + 0.9);
		
		startPage = ((int)((double)currentPage/10 + 0.9)-1)*limit +1;
		
		endPage = startPage + 9;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}

		dList = ns.selectDetailList(nno,currentPage,limit);
		
		String page = "";
		
		page="/WEB-INF/views/novelPage/DetailNovelList.jsp";
		request.setAttribute("nno", nno);
		request.setAttribute("DetailNovel", ni);
		request.setAttribute("dList", dList);
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		request.setAttribute("pi", pi);
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
