package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Articles_Approvisionnement;
import entities.Articles_Stock;
import entities.User;

public class configuration {
	
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		Configuration config = new Configuration();
		config.configure();
		
	    config.addAnnotatedClass(Articles_Approvisionnement.class);
	 	config.addAnnotatedClass(Articles_Stock.class);
		config.addAnnotatedClass(User.class);
		//config.addAnnotatedClass(abdellatif.hbm.class);
	

		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}