package edu.neu.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import edu.neu.model.Encounter;
import edu.neu.model.Patient;
import edu.neu.model.VitalSignWorkRequest;

@Repository
public class EncounterDAO extends DAO{
	
	public void createEncounter(String patientid,Encounter encounter,String loginuser)
	{
		
		Session session = getSession();
		session.beginTransaction();
		
		int id = Integer.parseInt(patientid);
		
		Patient patient = (Patient) session.get(Patient.class,id);
		
		Encounter e = new Encounter();
		e.setPatient(patient);
		e.setPatientComplaint(encounter.getPatientComplaint());
		e.setBriefSymptoms(encounter.getBriefSymptoms());
		e.setFrequencySymptoms(encounter.getFrequencySymptoms());
		e.setIsAlcoholic(encounter.getIsAlcoholic());
		e.setIsPregnant(encounter.getIsPregnant());
		e.setIsTobaccoConsumer(encounter.getIsTobaccoConsumer());
		e.setStarttimeSysmptoms(encounter.getStarttimeSysmptoms());
		patient.getEncounterslist().add(e);
		
		
		
		session.saveOrUpdate(patient);
		session.getTransaction().commit();
		session.close();
		
		int encounterid = e.getEncounterid();
		System.out.println("Encounter id "+encounterid);
		
		VitalSignWorkRequest vsr = new VitalSignWorkRequest();
		vsr.setDoctorname(loginuser);
		vsr.setNursename("Not Assigned");
		vsr.setWorkrequeststatus("VitalSigns to be recorded");
		vsr.setPatientid(id);
		vsr.setEncounterid(encounterid);
		
		Session session2 = getSession();
		session2.beginTransaction();
		
		session2.saveOrUpdate(vsr);
		
		session2.getTransaction().commit();
		session2.close();
		
	
		
		
	}
	
	

}
