package suongnguyen.learn.service;

import java.util.List;

import suongnguyen.learn.model.Product;

public interface ProductService {
	public void submit(Product data);
	public void delete(Integer id);
	public Product getById(Integer id);
	public List<Product> getAll();
}
