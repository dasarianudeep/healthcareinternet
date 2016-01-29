package edu.neu.model;

import javax.persistence.Entity;

@Entity
public class LabTestWorkRequest extends WorkRequest  {
	
	private String doctorname;
	
	private String labassistantname;
	
	private int patientid;
	
	private int encounterid;
	
	public LabTestWorkRequest()
	{
		
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getLabassistantname() {
		return labassistantname;
	}

	public void setLabassistantname(String labassistantname) {
		this.labassistantname = labassistantname;
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
