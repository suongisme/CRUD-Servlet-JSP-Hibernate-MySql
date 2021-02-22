package suongnguyen.learn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import suongnguyen.learn.dao.UserDao;
import suongnguyen.learn.model.User;


@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getServletPath().contentEquals("/logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("info_login");
			req.getRequestDispatcher("view/Logout.jsp").forward(req, resp);
			return;
		}
		if (req.getServletPath().contentEquals("/login")) {
			req.getRequestDispatcher("view/Login.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User userLogin = userDao.getById(username);
		if (userLogin == null) {
			req.setAttribute("stateLogin", "your username is incorrect");
			req.getRequestDispatcher("view/Login.jsp").forward(req, resp);
		} 

		if (!(userLogin.equals(user))) {
			req.setAttribute("stateLogin", "your password is incorrect");
			req.getRequestDispatcher("view/Login.jsp").forward(req, resp);
		} 

		session.setAttribute("info_login", user);
		resp.sendRedirect(req.getContextPath()+(String)session.getAttribute("link"));
	};
}
