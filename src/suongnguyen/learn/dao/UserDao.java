package suongnguyen.learn.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import suongnguyen.learn.model.Product;
import suongnguyen.learn.model.User;

public class UserDao implements DAO<String, User>{

	@Override
	public void submit(User data) {
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
		}
		
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(session.get(User.class, id));
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		
	}

	@Override
	public User getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		User user = null;
		try {
			transaction.begin();
			user = session.get(User.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		List<User> userList = null;
		try {
			transaction.begin();
			userList = session.createQuery("FROM User").list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return userList;
	}
}
