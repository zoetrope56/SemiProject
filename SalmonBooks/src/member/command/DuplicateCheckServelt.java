package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.SignInService;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class DuplicateCheckServelt
 */
@WebServlet("/duplicateCheck.do")
public class DuplicateCheckServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SignInService signInService = new SignInService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuplicateCheckServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		String id = request.getParameter("id");
		boolean duplicate = signInService.duplicateCheckId(id);
		JSONObject obj = new JSONObject();
		obj.put("result", duplicate);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
