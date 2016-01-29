package edu.neu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Encounter  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int encounterid;
	
	@ManyToOne
	@JoinColumn(name="patientID")
	private Patient patient;
	
	@NotEmpty(message="Field may not be left blank")
	private String patientComplaint;
   
	@NotEmpty(message="Field may not be left blank")
    private String briefSymptoms;
    
    @NotEmpty(message="Field may not be left blank")
    private String starttimeSysmptoms;
    
    @NotEmpty(message="Field may not be left blank")
    private String frequencySymptoms;
    
    @NotEmpty(message="Option may not be left blank")
    private String isAlcoholic;
    
    @NotEmpty(message="Option may not be left blank")
    private String isTobaccoConsumer;
    
    @NotEmpty(message="Option may not be left blank")
    private String isPregnant;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="VitalSignsID")
    private VitalSigns vitalSigns;
    
    @OneToMany(mappedBy="encounter",cascade=CascadeType.ALL)
    private List<Medication> medicationlist = new ArrayList<Medication>();
    
    private String consultedDoctor;
 
    private String doctorsAdvice;
  
    
    private String labTestResults;
    
   
    private String labTestType;
   
  
    private String vitalSignObservations;
    
    public Encounter()
    {
    	
    }
    
    

	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public List<Medication> getMedicationlist() {
		return medicationlist;
	}









	public void setMedicationlist(List<Medication> medicationlist) {
		this.medicationlist = medicationlist;
	}









	public String getDoctorsAdvice() {
		return doctorsAdvice;
	}









	public void setDoctorsAdvice(String doctorsAdvice) {
		this.doctorsAdvice = doctorsAdvice;
	}









	public String getPatientComplaint() {
		return patientComplaint;
	}

	public void setPatientComplaint(String patientComplaint) {
		this.patientComplaint = patientComplaint;
	}

	

	public String getBriefSymptoms() {
		return briefSymptoms;
	}

	public void setBriefSymptoms(String briefSymptoms) {
		this.briefSymptoms = briefSymptoms;
	}

	public String getStarttimeSysmptoms() {
		return starttimeSysmptoms;
	}

	public void setStarttimeSysmptoms(String starttimeSysmptoms) {
		this.starttimeSysmptoms = starttimeSysmptoms;
	}

	public String getFrequencySymptoms() {
		return frequencySymptoms;
	}

	public void setFrequencySymptoms(String frequencySymptoms) {
		this.frequencySymptoms = frequencySymptoms;
	}

	public String getIsAlcoholic() {
		return isAlcoholic;
	}

	public void setIsAlcoholic(String isAlcoholic) {
		this.isAlcoholic = isAlcoholic;
	}

	public String getIsTobaccoConsumer() {
		return isTobaccoConsumer;
	}

	public void setIsTobaccoConsumer(String isTobaccoConsumer) {
		this.isTobaccoConsumer = isTobaccoConsumer;
	}

	public String getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(String isPregnant) {
		this.isPregnant = isPregnant;
	}

	public VitalSigns getVitalSigns() {
		return vitalSigns;
	}

	public void setVitalSigns(VitalSigns vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	

	public String getConsultedDoctor() {
		return consultedDoctor;
	}

	public void setConsultedDoctor(String consultedDoctor) {
		this.consultedDoctor = consultedDoctor;
	}

	

	

	public int getEncounterid() {
		return encounterid;
	}



	public void setEncounterid(int encounterid) {
		this.encounterid = encounterid;
	}



	



	public String getLabTestResults() {
		return labTestResults;
	}

	public void setLabTestResults(String labTestResults) {
		this.labTestResults = labTestResults;
	}

	public String getLabTestType() {
		return labTestType;
	}

	public void setLabTestType(String labTestType) {
		this.labTestType = labTestType;
	}

	public String getVitalSignObservations() {
		return vitalSignObservations;
	}

	public void setVitalSignObservations(String vitalSignObservations) {
		this.vitalSignObservations = vitalSignObservations;
	}
    
    
    

}
