package edu.neu.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.neu.model.Employee;
import edu.neu.model.Encounter;
import edu.neu.model.Patient;
import edu.neu.model.Useraccount;

@Repository
public class UseraccountDAO extends DAO{
	
	public void addUseraccount(Useraccount useraccount)
	{

		String firstname = useraccount.getEmployee().getFirstname();
		String lastname = useraccount.getEmployee().getLastname();
		int ssn = useraccount.getEmployee().getSsn();
		
		
		
		
		System.out.println("Firstname "+useraccount.getEmployee().getFirstname());
		
	Employee e = new Employee();

	e.setFirstname(firstname);
	e.setLastname(lastname);
	e.setSsn(ssn);
    
	
	/*e.setAge(20);
    e.setCity("boston");
    e.setGender("male");*/
    
//	ua.setUsername(username);
//	ua.setPassword(password);
//	ua.setRole(role);
		
		useraccount.setEmployee(e);
		
		//try{
		Session session = getSession();
		session.beginTransaction();
		
		session.save(e);
		session.save(useraccount);
		session.getTransaction().commit();
		session.close();
		/*}
		catch(HibernateException he)
		{
			System.out.println("Exception thrown "+he);
		}*/
		
		
		
		
		
		
		
		
	}
	
	
	
	public String authenticateUser(String username,String password)
	{
		Session session = getSession();
		session.beginTransaction();
		
		Criteria cr = session.createCriteria(Useraccount.class);
		cr.add(Restrictions.eq("username",username)).add(Restrictions.eq("password",password));
		
		Useraccount ua = (Useraccount) cr.uniqueResult();
		String role = null;
		if(ua!=null){
		 role = ua.getRole();
		}
		
		return role;
		
		
	}
	
	public void addPatientUseraccount(Useraccount useraccount,String city,String gender,int ssn,int age,String firstname,String lastname)
	{
		
		Patient p = new Patient();
		
		p.setAge(age);
		p.setCity(city);
		p.setFirstname(firstname);
		p.setGender(gender);
		p.setLastname(lastname);
		p.setSsn(ssn);
	
		useraccount.setRole("patient");
		useraccount.setEmployee(p);
		
		Session session = getSession();
		session.beginTransaction();
		
		session.save(p);
		session.save(useraccount);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
