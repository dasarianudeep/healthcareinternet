package edu.neu.service;

import edu.neu.model.Encounter;

public abstract class ImplementEncounterService {
	
	public abstract void createEncounter(String patientid,Encounter encounter,String loginuser);

}
