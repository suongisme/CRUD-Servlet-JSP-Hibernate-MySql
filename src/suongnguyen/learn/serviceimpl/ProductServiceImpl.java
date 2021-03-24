package suongnguyen.learn.serviceimpl;

import java.util.List;

import suongnguyen.learn.dao.ProductDAO;
import suongnguyen.learn.daoimpl.ProductDaoImpl;
import suongnguyen.learn.model.Product;
import suongnguyen.learn.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDAO productDao = new ProductDaoImpl();
	
	@Override
	public void submit(Product data) {
		if (data == null) return;
		productDao.submit(data);
	}

	@Override
	public void delete(Integer id) {
		if (id < 0) return;
		productDao.delete(id);
	}

	@Override
	public Product getById(Integer id) {
		if (id < 0) return null;
		return productDao.getById(id);
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

}
