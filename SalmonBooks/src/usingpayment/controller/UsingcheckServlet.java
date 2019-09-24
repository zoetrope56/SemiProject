package usingpayment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import novel.service.NovelService;
import novel.vo.DetailNovel;
import novel.vo.NovelInfo;
import payment.model.vo.Payment;
import usingpayment.model.service.UsingPaymentService;
import usingpayment.model.vo.UsingPayment;

/**
 * Servlet implementation class UsingcheckServlet
 */
@WebServlet("/usingcheck.do")
public class UsingcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsingcheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession httpSession = request.getSession(false); 
//		User user =  (User)httpSession.getAttribute("authUser");
//
//		String userId = user.getId();
		int nno = Integer.parseInt(request.getParameter("nno"));
		int dno = Integer.parseInt(request.getParameter("dno"));
		int listCount = Integer.parseInt(request.getParameter("listcount"));

		NovelService novelService = new NovelService();
		DetailNovel detailNovel = novelService.selectViewOne(nno, dno);
		NovelInfo novelInfo = novelService.selectOne(nno);
		request.setAttribute("detailNovel", detailNovel);
		request.setAttribute("NovelInfo", novelInfo);
		request.setAttribute("listcount", listCount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/detailpay.jsp"); //필터연결 
		dispatcher.forward(request, response);




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기서 결제 하는 거 처리를 하고 그 소설로 다시 보내줘 원래 소설 페이지로 ㅇㅋ?
		// 이곳은 소설 페이지에서 결제를 안했으면 클릭한 소설화수(dno)를 통해 제목 받아오고 포인트 값 받아와서 결제하는 부분 
		System.out.println("결제할거야!!!!!");
		
		HttpSession httpSession = request.getSession(false); 
		User user =  (User)httpSession.getAttribute("authUser");
		System.out.println("널널널 " + user);
		String userId = user.getId();
		System.out.println(userId);
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		int dno = Integer.parseInt(request.getParameter("dno"));
		String title = request.getParameter("title");
		int pay = Integer.parseInt(request.getParameter("pay"));
		int listcount = Integer.parseInt(request.getParameter("listcount"));
		
		NovelService novelService = new NovelService();
		DetailNovel detailNovel = novelService.selectViewOne(nno, dno);
		NovelInfo novelInfo = novelService.selectOne(nno);
		request.setAttribute("detailNovel", detailNovel);
		request.setAttribute("NovelInfo", novelInfo);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/detailpay.jsp"); //필터연결 
//		dispatcher.forward(request, response);
		System.out.println("값은 전달은 되었니 ? " +nno+dno+title+pay);
		
		UsingPayment up = new UsingPayment();
		Payment p = new Payment();
		up.setUserId(userId);
		System.out.println("up.getUserId : " + up.getUserId());
		up.setDno(dno);
		up.setNno(nno);
		up.setTitle(title);
		up.setPay(pay);
		
		System.out.println(up.toString());
		
		int result2 = new UsingPaymentService().pointusing(up,p);
		//response.sendRedirect("");
		//소설 뷰어로 리다이렉트
		String page = "";
		
			if(result2 >0) {
				int result = new UsingPaymentService().insert(up);
				response.sendRedirect("ViewNovel.do?nno="+nno+"&dno="+dno+"&listcount="+listcount+"&free=TRUE");
				System.out.println("성공");
			}
			
			else if(result2 == 0 ) {
				 page ="/WEB-INF/views/errorpoint.jsp";
				 request.getRequestDispatcher(page).forward(request, response);
				
			}
			
			else {
				request.setAttribute("result", "실패");
				System.out.println("실패");
			}
				
		
		
		
		
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/novelPage/DetailNovelList.jsp"); //필터연결 
//		dispatcher.forward(request, response);
	}
}
