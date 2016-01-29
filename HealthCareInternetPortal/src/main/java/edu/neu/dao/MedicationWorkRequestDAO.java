package edu.neu.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.neu.model.Encounter;
import edu.neu.model.Medication;
import edu.neu.model.MedicationWorkRequest;

@Repository
public class MedicationWorkRequestDAO extends DAO {
	
	
	public void addMedication(String pid,String eid,String drugname,String drugdosage,String quantity,String advice,String loginuser)
	{
		int encounterid = Integer.parseInt(eid);
		int patientid = Integer.parseInt(pid);
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Encounter.class);
		criteria.add(Restrictions.eq("encounterid",encounterid));
		criteria.add(Restrictions.eq("patient.employeeid",patientid));
		
		Encounter encounter = (Encounter) criteria.uniqueResult();
		
		Medication medication = new Medication();
		medication.setDrugname(drugname);
		medication.setDrugdosage(drugdosage);
		medication.setQuantity(quantity);
		medication.setAdvice(advice);
		medication.setEncounter(encounter);
		
		encounter.getMedicationlist().add(medication);
		session.saveOrUpdate(encounter);
	
		MedicationWorkRequest medicationworkrequest = new MedicationWorkRequest();
		medicationworkrequest.setDoctorname(loginuser);
		medicationworkrequest.setEncounterid(encounterid);
		medicationworkrequest.setPatientid(patientid);
		medicationworkrequest.setWorkrequeststatus("Medication Prescribed");
		
		
		session.save(medicationworkrequest);
		
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
