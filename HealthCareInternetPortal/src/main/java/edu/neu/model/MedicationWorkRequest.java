package edu.neu.model;

import javax.persistence.Entity;

@Entity
public class MedicationWorkRequest extends WorkRequest{
	
	private String doctorname;
	
	private int patientid;
	
	private int encounterid;
	
	public MedicationWorkRequest()
	{
		
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getEncounterid() {
		return encounterid;
	}

	public void setEncounterid(int encounterid) {
		this.encounterid = encounterid;
	}

	
	
	

}
