package edu.neu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Patient extends Employee {
	
	
	@NotEmpty(message="Gender cannot be left blank")
	private String gender;
	
	@NotNull(message="Age cannot be left blank")
	private int age;
	
	@NotEmpty(message="City cannot be left blank")
	private String city;
	
	
	public Useraccount getUseraccount() {
		return useraccount;
	}



	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}
    @Transient
	@Valid
	private Useraccount useraccount;
	
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
    private List<Encounter> encounterslist = new ArrayList<Encounter>();
	
	
	public Patient()
	{
		
	}
	


	public List<Encounter> getEncounterslist() {
		return encounterslist;
	}














	public void setEncounterslist(List<Encounter> encounterslist) {
		this.encounterslist = encounterslist;
	}














	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	
	

}
