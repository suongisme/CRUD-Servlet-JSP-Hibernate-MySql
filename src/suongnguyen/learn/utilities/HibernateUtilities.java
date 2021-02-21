package suongnguyen.learn.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilities {
	
	public static SessionFactory getSessionFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
									  .configure()
									  .build();
		MetadataSources ms = new MetadataSources( ssr );
		Metadata m = ms.buildMetadata();
		return m.buildSessionFactory();
	}
}
