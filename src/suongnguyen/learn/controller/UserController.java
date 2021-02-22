package suongnguyen.learn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import suongnguyen.learn.dao.UserDao;
import suongnguyen.learn.model.User;

@WebServlet("/users/*")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if (pathInfo != null) {
			String username = pathInfo.substring(1);
			String isDelete = req.getParameter("delete");
			if ("true".equals(isDelete)) {
				userDao.delete(username);
			}
		}
		
		req.setAttribute("users", userDao.getAll());
		req.getRequestDispatcher("view/User.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		userDao.submit(user);
		req.setAttribute("users", userDao.getAll());
		req.getRequestDispatcher("view/User.jsp").forward(req, resp);
	
	}

}
