package edu.neu.service;

import edu.neu.model.Useraccount;

public abstract class ImplementUseraccountService {
	
	public abstract void addUseraccount(Useraccount useraccount);
	
	public abstract String authenticateUser(String username,String password);
	
	public abstract void addPatientUseraccount(Useraccount useraccount,String city,String gender,int ssn,int age,String firstname,String lastname);
	
	
	
		
	
	
		
	

}
