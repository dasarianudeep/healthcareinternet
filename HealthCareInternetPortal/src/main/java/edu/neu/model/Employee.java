package edu.neu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO)
	private int employeeid;
	
	@NotEmpty(message="Fist Name cannot be left empty")
	@Pattern(regexp="^[a-zA-Z]+$", message="Should  contain only characters")
	private String firstname;
	
	@NotEmpty(message="Last Name cannot be left empty")
	@Pattern(regexp="^[a-zA-Z]+$", message="Should  contain only characters")
	private String lastname;
	
	@NotNull(message="SSN cannot be left empty")
	@Range(min=100000000,max=999999999,message="SSN should be of 9 digits")
	private int ssn;
	
	
	
	
	public Employee()
	{
		
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	
	
	public String toString()
	{
		return firstname;
	}
	

}
