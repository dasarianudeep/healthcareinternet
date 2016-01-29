package edu.neu.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VitalSigns implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private int bodytemperature;
	
	private int bloodpressure;
	
	private int pulserate;
	
	private int respiratoryrate;
	
	public VitalSigns()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBodytemperature() {
		return bodytemperature;
	}

	public void setBodytemperature(int bodytemperature) {
		this.bodytemperature = bodytemperature;
	}

	public int getBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(int bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public int getPulserate() {
		return pulserate;
	}

	public void setPulserate(int pulserate) {
		this.pulserate = pulserate;
	}

	public int getRespiratoryrate() {
		return respiratoryrate;
	}

	public void setRespiratoryrate(int respiratoryrate) {
		this.respiratoryrate = respiratoryrate;
	}
	
	

}
