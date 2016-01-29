package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.dao.VitalSignsDAO;
import edu.neu.model.VitalSigns;

@Repository
public class VitalSignsService extends ImplementVitalSignsService {
	
	@Autowired
	private VitalSignsDAO vitalSignsDAO;

	@Override
	public void addVitalSigns(String pid, String eid, VitalSigns vitalSigns,String vswrid) {
		// TODO Auto-generated method stub
		vitalSignsDAO.addVitalSigns(pid, eid, vitalSigns,vswrid);
		
	}

	@Override
	public VitalSigns getVitalSigns(String patientid, String encounterid,String vswrid) {
		// TODO Auto-generated method stub
		
		return vitalSignsDAO.getVitalSigns(patientid, encounterid,vswrid);
		
	}

}
