package suongnguyen.learn.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		
		HttpSession session = req.getSession(false);
		System.out.println(session.getId());
		session.invalidate();
		resp.sendRedirect(req.getContextPath()+"/view/Logout.jsp");
		
	};
}
