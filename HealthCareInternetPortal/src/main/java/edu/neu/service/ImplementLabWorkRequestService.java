package edu.neu.service;

import java.util.List;

import edu.neu.model.Encounter;
import edu.neu.model.LabTestWorkRequest;
public abstract class ImplementLabWorkRequestService {
	
	public abstract List<LabTestWorkRequest> getLabRequestsforDoctor(String loginuser);
	
	public abstract void sendToLab(String pid,String eid,String loginuser,String vitalSignObservations);
	
	public abstract void addLabResults(String pid,String eid,String ltwid,String labTestType,String labTestResults);
	
	public abstract Encounter getLabResults(String patientid,String encounterid,String ltwrid);
	

}
