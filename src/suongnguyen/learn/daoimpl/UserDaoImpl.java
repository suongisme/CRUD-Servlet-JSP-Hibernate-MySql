package suongnguyen.learn.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import suongnguyen.learn.dao.UserDAO;
import suongnguyen.learn.model.User;
import suongnguyen.learn.utilities.HibernateUtilities;

public class UserDaoImpl implements UserDAO{

	SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
	
	@Override
	public void submit(User data) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.saveOrUpdate(data);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User user = session.get(User.class, id);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public User getById(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		User user = null;
		try {
			transaction.begin();
			user = session.get(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		List<User> userList = null;
		try {
			transaction.begin();
			userList = session.createQuery("FROM User").list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return userList;
	}
}
