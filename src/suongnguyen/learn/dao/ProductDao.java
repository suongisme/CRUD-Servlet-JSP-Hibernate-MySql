package suongnguyen.learn.dao;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import suongnguyen.learn.model.Product;

public class ProductDao implements DAO<Integer, Product>{

	@Override
	public void submit(Product data) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.saveOrUpdate(data);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Product product = session.get(Product.class, id);
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
	public Product getById(Integer id) {
		Product product = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			product = session.find(Product.class, 1);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> listProduct = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
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
