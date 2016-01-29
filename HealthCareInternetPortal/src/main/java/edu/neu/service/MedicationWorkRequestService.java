package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.dao.MedicationWorkRequestDAO;


@Service
public class MedicationWorkRequestService  extends ImplementMedicationWorkRequest{

	@Autowired
	private MedicationWorkRequestDAO medicationWorkRequestDAO;

	@Override
	public void addMedication(String pid, String eid, String drugname,
			String drugdosage, String quantity, String advice,String loginuser) {
		// TODO Auto-generated method stub
		
		medicationWorkRequestDAO.addMedication(pid, eid, drugname, drugdosage, quantity, advice,loginuser);
		
	}
	
	
}
