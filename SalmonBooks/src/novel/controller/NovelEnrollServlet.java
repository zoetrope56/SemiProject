package novel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import auth.service.User;
import novel.service.NovelService;
import novel.vo.NovelInfo;

/**
 * Servlet implementation class SimpNovelEnrollServlet
 */
@WebServlet("/novelEnroll.do")
public class NovelEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NovelEnrollServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "/WEB-INF/views/novelPage/NovelEnrollForm.jsp";
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
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
				HttpSession httpSession = request.getSession(false);
				if(httpSession != null && httpSession.getAttribute("authUser")!= null) {
					System.out.println(((User)httpSession.getAttribute("authUser")).getId());
				}
				String nWriter = ((User)httpSession.getAttribute("authUser")).getId();
				String title = mrequest.getParameter("title");
				String genre = mrequest.getParameter("genre");
				String free = mrequest.getParameter("chk_free");
				int pay = Integer.parseInt(mrequest.getParameter("pay"));
				String nSimpContent = mrequest.getParameter("simpleContent");
				String filename = mrequest.getFilesystemName("file");
				String img = request.getContextPath()+"/resource/image/novelimage/"+mrequest.getFilesystemName("file");
				
				
				NovelInfo novel = new NovelInfo();
				novel.setnWriter(nWriter);
				novel.setNtitle(title);
				novel.setGenre(genre);
				novel.setFree(free);
				novel.setPay(pay);
				novel.setnSimpContent(nSimpContent);
				novel.setImg(img);
				System.out.println("NovelInsert(서블릿) : "+ novel.getnWriter() + novel.getNtitle() + novel.getGenre() + novel.getFree() + novel.getPay() + novel.getnSimpContent() + "  이미지 경로: "+ novel.getImg());
				
				int result = new NovelService().insertNovel(novel);
				NovelInfo ni = new NovelService().selectLastInsertedNovel(((User)httpSession.getAttribute("authUser")).getId());
				response.sendRedirect("novelUpload.do?nno="+ni.getNno());
	}

}
