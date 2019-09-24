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
import novelComment.service.NovelCommentService;
import novelComment.vo.NovelComment;

/**
 * Servlet implementation class ViewNovelServlet
 */
@WebServlet("/ViewNovel.do")
public class ViewNovelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNovelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nno = Integer.parseInt(request.getParameter("nno"));
		int dno = Integer.parseInt(request.getParameter("dno"));
		int listcount = Integer.parseInt(request.getParameter("listcount"));
		String free = request.getParameter("free");
		NovelService ns = new NovelService();
		DetailNovel dn = ns.selectViewOne(nno,dno);
		ArrayList<NovelComment> cList = new NovelCommentService().selectList(nno,dno);
		String page = "";
		
		page = "WEB-INF/views/novelPage/ReadNovelView.jsp";
		
		request.setAttribute("dn", dn);
		request.setAttribute("dno", dno);
		request.setAttribute("nno", nno);
		request.setAttribute("free", free);
		request.setAttribute("listcount", listcount);
		request.setAttribute("cList", cList);
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
