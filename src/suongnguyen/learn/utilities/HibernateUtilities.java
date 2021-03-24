package suongnguyen.learn.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.mysql.cj.Session;

public class HibernateUtilities {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources ms = new MetadataSources(ssr);
			sessionFactory = ms.buildMetadata().buildSessionFactory();
		}

		return sessionFactory;
	}
}
