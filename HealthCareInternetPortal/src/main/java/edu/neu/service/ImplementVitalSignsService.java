package edu.neu.service;

import edu.neu.model.VitalSigns;

public abstract class ImplementVitalSignsService {
	

	public abstract void addVitalSigns(String pid,String eid,VitalSigns vitalSigns,String vswrid);
	
	public abstract VitalSigns getVitalSigns(String patientid,String encounterid,String vswrid);


}
