package suongnguyen.learn.filter;

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

import suongnguyen.learn.model.User;

public class SecurityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("info_login");
		
		String servletPath = req.getServletPath();
		servletPath = servletPath.equals("/logout") ? "/home" : servletPath;
		String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
		
		if (user == null) {
			session.setAttribute("link", servletPath+pathInfo);
			((HttpServletResponse) response).sendRedirect(req.getContextPath()+"/login");
			return;
		} 
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
