package suongnguyen.learn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import suongnguyen.learn.model.User;
import suongnguyen.learn.service.UserService;
import suongnguyen.learn.serviceimpl.UserServiceImpl;

@WebServlet("/users/*")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		
		if (pathInfo != null) {
			String username = pathInfo.substring(1);
			String isDelete = req.getParameter("delete");
			if ("true".equals(isDelete)) {
				userService.delete(username);
			}
		}
		
		req.setAttribute("users", userService.getAll());
		req.getRequestDispatcher("/view/User.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		userService.submit(user);
		req.setAttribute("users", userService.getAll());
		req.getRequestDispatcher("/view/User.jsp").forward(req, resp);
	
	}

}
