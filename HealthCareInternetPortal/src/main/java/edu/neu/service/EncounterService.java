package edu.neu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.dao.EncounterDAO;
import edu.neu.model.Encounter;

@Service
public class EncounterService extends ImplementEncounterService{
	
	@Autowired
	private EncounterDAO encounterDAO;

	@Override
	public void createEncounter(String patientid, Encounter encounter,String loginuser) {
		// TODO Auto-generated method stub
		encounterDAO.createEncounter(patientid, encounter,loginuser);
	}

}
