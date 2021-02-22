package suongnguyen.learn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import suongnguyen.learn.dao.ProductDao;
import suongnguyen.learn.model.Product;

@WebServlet("/products/*")
public class ProductController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ProductDao productDao;
	
	@Override
	public void init() throws ServletException {
		productDao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		if (pathInfo != null) {
			int id = Integer.parseInt(pathInfo.substring(1).trim());
			String isDelete = req.getParameter("delete");
			if ("true".equals(isDelete)) {
				productDao.delete(id);
			} 
		} 
		
		req.setAttribute("products", productDao.getAll());
		req.getRequestDispatcher("/view/Product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("ID");
		String name = req.getParameter("Name");
		String price = req.getParameter("Price");
		String desc = req.getParameter("Description");
		System.out.println(id);
		Product product = new Product();
		if (!(id.equals(""))) product.setId(Integer.parseInt(id));
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setDesc(desc);
		
		productDao.submit(product);
		req.setAttribute("products", productDao.getAll());
		req.getRequestDispatcher("view/Product.jsp").forward(req, resp);
	
	}
}
