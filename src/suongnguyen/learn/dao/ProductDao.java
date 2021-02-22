package suongnguyen.learn.dao;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import suongnguyen.learn.model.Product;

public class ProductDao implements DAO<String, Product>{

	@Override
	public void submit(Product data) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(data);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Product product = session.find(Product.class, id);
			session.delete(product);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public Product getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> listProduct = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			listProduct = session.createQuery("FROM Product").list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		
		
		return listProduct;
	}

}
