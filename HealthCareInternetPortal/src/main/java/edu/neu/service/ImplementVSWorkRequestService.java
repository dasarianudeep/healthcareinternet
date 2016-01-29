package edu.neu.service;

import java.util.List;

import edu.neu.model.VitalSignWorkRequest;
import edu.neu.model.VitalSigns;

public abstract class ImplementVSWorkRequestService {
	
	
	
	public abstract List<VitalSignWorkRequest> getVSWRListforNurse();
	
	
	public abstract List<VitalSignWorkRequest> getVSWRListforDoctor(String loginuser);
	
	
}
