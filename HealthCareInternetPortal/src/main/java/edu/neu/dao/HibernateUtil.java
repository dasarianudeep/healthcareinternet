package edu.neu.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static final SessionFactory sessionfactory;
	
	static
	{
		try{
			System.out.println("IN");
		sessionfactory = new Configuration().configure().buildSessionFactory();
		System.out.println("Connected to DB");
		}
		catch(Throwable ex)
		{
			 System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionfactory;
	}
	
	

}
