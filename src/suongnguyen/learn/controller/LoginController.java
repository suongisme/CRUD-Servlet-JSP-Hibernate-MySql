package suongnguyen.learn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import suongnguyen.learn.daoimpl.UserDaoImpl;
import suongnguyen.learn.model.User;


@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UserDaoImpl userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("view/Login.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User userLogin = userDao.getById(username);

		if (userLogin == null) {
			req.setAttribute("stateLogin", "your username is incorrect");
			req.getRequestDispatcher("view/Login.jsp").forward(req, resp);
			return;
		} 

		if (!(userLogin.getPassword().equals(password))) {
			req.setAttribute("stateLogin", "your password is incorrect");
			req.getRequestDispatcher("view/Login.jsp").forward(req, resp);
			return;
		} 

		session.setAttribute("info_login", userLogin);
		resp.sendRedirect(req.getContextPath()+(String)session.getAttribute("link"));
	};
}
