package edu.neu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Medication implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int medicationid;
	
	@NotEmpty(message="Drugname cannot be left empty")
	private String drugname;
	
	@NotEmpty(message="Drugdosage cannot be left empty")
	private String drugdosage;
	
	@NotEmpty(message="Please provide your advice")
	private String advice;
	
	@NotEmpty(message="Please enter quantity of drugs")
	@Pattern(regexp="^[0-9]+$",message="Invalid input")
	private String quantity;
	
	@ManyToOne
	@JoinColumn(name="EncounterID")
	private Encounter encounter;
	
	public Medication()
	{
		
	}
	
	

	
	



	public Encounter getEncounter() {
		return encounter;
	}



	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}



	public int getMedicationid() {
		return medicationid;
	}

	public void setMedicationid(int medicationid) {
		this.medicationid = medicationid;
	}

	

	public String getDrugname() {
		return drugname;
	}



	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}



	

	public String getDrugdosage() {
		return drugdosage;
	}








	public void setDrugdosage(String drugdosage) {
		this.drugdosage = drugdosage;
	}








	public String getQuantity() {
		return quantity;
	}








	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}








	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
	
	
	

}
