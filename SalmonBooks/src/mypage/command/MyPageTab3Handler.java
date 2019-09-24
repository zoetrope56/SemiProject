package mypage.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import mypage.service.MyPageService;
import novel.vo.NovelInfo;

public class MyPageTab3Handler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/views/mypage/myPage_3.jsp";
	private MyPageService myPageService = new MyPageService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("get");
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("post");
			return processSubmit(req, res);
		}
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		User user = (User)req.getSession().getAttribute("authUser");
		ArrayList<NovelInfo> novelList = null;

		try {
			novelList = myPageService.searchNovel(user.getId());
			if(novelList==null||novelList.isEmpty())
				System.out.println(novelList);
			req.getSession().setAttribute("novelList", novelList);

			res.sendRedirect(req.getContextPath()+"/novelEnroll.do");

		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		User user = (User)req.getSession().getAttribute("authUser");
		ArrayList<NovelInfo> novelList = myPageService.searchNovel(user.getId());
		if(novelList==null||novelList.isEmpty())
			System.out.println(novelList);
		req.getSession().setAttribute("novelList", novelList);

		return FORM_VIEW;
	}
}
