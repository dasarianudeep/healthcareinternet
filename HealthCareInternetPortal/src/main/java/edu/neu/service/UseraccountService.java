package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.dao.UseraccountDAO;
import edu.neu.model.Useraccount;

@Service
public class UseraccountService extends ImplementUseraccountService{
	
	@Autowired
	private UseraccountDAO useraccountDAO;

	@Override
	public void addUseraccount(Useraccount useraccount) {
		// TODO Auto-generated method stub
		
		
		useraccountDAO.addUseraccount(useraccount);
		
		
	}

	@Override
	public String authenticateUser(String username,String password) {
		// TODO Auto-generated method stub
		return useraccountDAO.authenticateUser(username, password);
	}

	@Override
	public void addPatientUseraccount(Useraccount useraccount, String city,
			String gender, int ssn, int age, String firstname, String lastname) {
		// TODO Auto-generated method stub
		
		useraccountDAO.addPatientUseraccount(useraccount, city, gender, ssn, age, firstname, lastname);
		
	}
	
	

}
