package novelComment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import novelComment.service.NovelCommentService;
import novelComment.vo.NovelComment;

/**
 * Servlet implementation class CommentInertServlet
 */
@WebServlet("/insertComment.do")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String writer = request.getParameter("writer");
		int nno = Integer.parseInt(request.getParameter("nno"));
		int dno = Integer.parseInt(request.getParameter("dno"));
		String content = request.getParameter("replyContent");
		int refcno = Integer.parseInt(request.getParameter("refcno"));
		int clevel = Integer.parseInt(request.getParameter("clevel"));
		System.out.println(clevel);
		int listCount = Integer.parseInt(request.getParameter("listcount"));
		String free = request.getParameter("free");
		NovelComment nco = new NovelComment(nno,dno,content,writer,refcno,clevel);
	
		int result = new NovelCommentService().insertComment(nco);
	
		
		response.sendRedirect("ViewNovel.do?nno="+nno+"&dno="+dno+"&listcount="+listCount+"&free="+free);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
