package edu.neu.model;

import javax.persistence.*;

@Entity
public class VitalSignWorkRequest extends WorkRequest{
	
	private String doctorname;
	
	private String nursename;
	
	private int patientid;
	
	private int encounterid;
	
	
	public VitalSignWorkRequest()
	{
		
	}


	public String getDoctorname() {
		return doctorname;
	}


	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}


	public String getNursename() {
		return nursename;
	}


	public void setNursename(String nursename) {
		this.nursename = nursename;
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
