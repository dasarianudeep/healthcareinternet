package edu.neu.dao;

import org.hibernate.Session;

public class DAO {
	
	protected DAO()
	{
		
	}
	
	protected Session getSession()
	{
		return HibernateUtil.getSessionFactory().openSession();
	}
	
	

}
