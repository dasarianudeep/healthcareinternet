package edu.neu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.dao.VitalSignWorkRequestDAO;
import edu.neu.model.VitalSignWorkRequest;
import edu.neu.model.VitalSigns;

@Service
public class VSWorkRequestService extends ImplementVSWorkRequestService{
	
	@Autowired
	private VitalSignWorkRequestDAO vitalSignWorkRequestDAO;

	@Override
	public List<VitalSignWorkRequest> getVSWRListforNurse() {
		// TODO Auto-generated method stub
		return vitalSignWorkRequestDAO.getVSWRListforNurse();
	}
	
	public  List<VitalSignWorkRequest> getVSWRListforDoctor(String loginuser)
	{
		return vitalSignWorkRequestDAO.getVSWRListforDoctor(loginuser);
	}

	

}
