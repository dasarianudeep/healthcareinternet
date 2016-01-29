package edu.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.dao.LabTestWorkRequestDAO;
import edu.neu.model.Encounter;
import edu.neu.model.LabTestWorkRequest;

@Service
public class LabWorkRequestService extends ImplementLabWorkRequestService{
    
	@Autowired
	private LabTestWorkRequestDAO labTestWorkRequestDAO;
	@Override
	public List<LabTestWorkRequest> getLabRequestsforDoctor(String loginuser) {
		// TODO Auto-generated method stub
		return labTestWorkRequestDAO.getLabRequestsforDoctor(loginuser);
	}

	
	public void sendToLab(String pid,String eid,String loginuser,String vitalSignObservations)
	{
		labTestWorkRequestDAO.sendToLab(pid, eid, loginuser,vitalSignObservations);
	}
	
	public List<LabTestWorkRequest> getLabRequestsforLA()
	{
		
		return labTestWorkRequestDAO.getLabRequestsforLabAssitant();
	}


	@Override
	public void addLabResults(String pid, String eid, String ltwid,
			String labTestType, String labTestResults) {
		// TODO Auto-generated method stub
		labTestWorkRequestDAO.addLabResults(pid, eid, ltwid, labTestType, labTestResults);
		
	}


	@Override
	public Encounter getLabResults(String patientid, String encounterid,
			String ltwrid) {
		// TODO Auto-generated method stub
		return labTestWorkRequestDAO.getLabResults(patientid, encounterid, ltwrid);
	}
}
