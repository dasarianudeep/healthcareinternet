package edu.neu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Useraccount implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int useraccountid;
	
	@NotEmpty(message="Username cannot be left empty")
	@Pattern(regexp="^[a-zA-Z]+$", message="Should  contain only characters")
	@Size(min=6,message="Username should be of minimum length 6")
	private String username;
	
	@NotEmpty(message="Password cannot be left empty")
	private String password;
	
	@OneToOne
	@JoinColumn(name="EmployeeID")
	@Valid
	private Employee employee;
	
	@NotEmpty(message="Role cannot be left empty")
	private String role;
	
	
	
	public Useraccount()
	{
		
	}
	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getUseraccountid() {
		return useraccountid;
	}

	public void setUseraccountid(int useraccountid) {
		this.useraccountid = useraccountid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	
	
	public String toString()
	{
		return username;
	}
	
	

}
