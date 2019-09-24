package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import payment.model.vo.Payment;
import usingpayment.model.service.UsingPaymentService;
import usingpayment.model.vo.UsingPayment;

public class FreeCheckFilter implements Filter{

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)   
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		System.out.println(	request.getParameter("nno"));
		System.out.println("들어오냐"+((User)req.getSession(false).getAttribute("authUser")).getId());	
		if(request.getParameter("free").equals("TRUE")) {
			chain.doFilter(request, response);
		}
		else {
			System.out.println("확인해주세요");
			
//			res.sendRedirect(req.getContextPath()+"/usingcheck.do?nno="+Integer.parseInt(req.getParameter("nno"))+"&dno="+Integer.parseInt(req.getParameter("dno")));

			HttpSession httpSession = req.getSession(false); 
			User user =  (User)httpSession.getAttribute("authUser");

			String userId = user.getId();

			int nno = Integer.parseInt(request.getParameter("nno"));
			int dno = Integer.parseInt(request.getParameter("dno"));
			int listCount = Integer.parseInt(request.getParameter("listcount"));

			//if ( result 가 true)
			//소설상세페이지 
			//else ( result 가 false) 
			//결제페이지
			UsingPayment up = new UsingPayment();
			
			up.setUserId(userId);
			up.setDno(dno);
			up.setNno(nno);
		
			
			
			String result =new UsingPaymentService().checkUsing(up); // 리절트 값으 true false 

			if(result.equals("true")) {
				chain.doFilter(req, res);
				System.out.println("소설상세페이지로 이동합니다");

			}else if(result.equals("false")) {
				res.sendRedirect("usingcheck.do?nno="+nno+"&dno="+dno+"&listcount="+listCount);
				System.out.println("결제페이지로 이동합니다");
			}else {
				req.setAttribute("result", "실패");
				System.out.println("실패입니다");
			}
		}


	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}