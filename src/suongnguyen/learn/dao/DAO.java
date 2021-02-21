package suongnguyen.learn.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import suongnguyen.learn.utilities.HibernateUtilities;

public interface DAO<I,D> {
	SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();
	void submit(D data);
	void delete(I id);
	D getById(I id);
	List<D> getAll();
}
