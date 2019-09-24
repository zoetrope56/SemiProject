package novel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import auth.service.User;
import novel.service.NovelService;
import novel.vo.DetailNovel;
import novel.vo.NovelInfo;

/**
 * Servlet implementation class NovelUploadServlet
 */
@WebServlet("/novelUpload.do")
public class NovelUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovelUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "/WEB-INF/views/novelPage/NovelUploadForm.jsp";
		int nno = Integer.parseInt(request.getParameter("nno"));
		request.setAttribute("nno", nno);
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 1024 * 1024 * 10;
		
		String root = request.getServletContext().getRealPath("/");
		System.out.println("request.getServletContext().getRealPath(\"/\") : "+root);
		
		String savePath = root + "resource/image/novelimage";
		System.out.println(savePath);
		MultipartRequest mrequest = new MultipartRequest(
				request,
				savePath,
				maxSize,
				"UTF-8",  
				new DefaultFileRenamePolicy()
				);
		
		// -- 파일업로드 실시 --
		int nno = Integer.parseInt(mrequest.getParameter("nno"));//수정수정수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		String title = mrequest.getParameter("title");
		String img = request.getContextPath()+"/resource/image/novelimage/"+mrequest.getFilesystemName("file");
		String content = mrequest.getParameter("content");
		
		
		DetailNovel uplnovel = new DetailNovel();
		uplnovel.setNno(nno);
		uplnovel.setdTitle(title);
		uplnovel.setImg(img);
		uplnovel.setContent(content);

		
		System.out.println("Novelupload(서블릿) : "+ uplnovel.getdTitle() + uplnovel.getImg() + uplnovel.getContent());
		
		int result = new NovelService().uploadNovel(uplnovel);
		System.out.println("서블릿 업데이트 확인: " +result);
		
		response.sendRedirect(request.getContextPath()+"/selectOne.do?nno="+nno);
	}

}
