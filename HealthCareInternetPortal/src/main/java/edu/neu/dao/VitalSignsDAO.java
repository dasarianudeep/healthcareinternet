package edu.neu.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.neu.model.Encounter;
import edu.neu.model.VitalSignWorkRequest;
import edu.neu.model.VitalSigns;

@Repository
public class VitalSignsDAO extends DAO{
	
	
	public void addVitalSigns(String pid,String eid,VitalSigns vitalSigns,String vswrid)
	{
		Session session= getSession();
		session.beginTransaction();
		
		int patientid = Integer.parseInt(pid);
		int encounterid = Integer.parseInt(eid);
		int workrequestid = Integer.parseInt(vswrid);
		
		System.out.println("patientid "+patientid);
		System.out.println("encounterid "+encounterid);
		
		VitalSignWorkRequest vsr = (VitalSignWorkRequest) session.get(VitalSignWorkRequest.class, workrequestid);
		vsr.setWorkrequeststatus("VitalSigns Recorded");
		//vsr.setNursename("");
//		Criteria criteria = session.createCriteria(Encounter.class,"encounter");
//		criteria.add(Restrictions.eq("encounterid",encounterid));
//		criteria.add(Restrictions.eq("encounter.patient",patientid));
		
 Query query = session.createQuery("from Encounter e where e.patient.employeeid=:patientid and e.encounterid=:encounterid");
 query.setParameter("patientid", patientid);
 query.setParameter("encounterid", encounterid);
		Encounter encounter = (Encounter) query.uniqueResult();
		
		VitalSigns vs = new VitalSigns();
		
		vs.setBloodpressure(vitalSigns.getBloodpressure());
		vs.setBodytemperature(vitalSigns.getBodytemperature());
		vs.setPulserate(vitalSigns.getPulserate());
        vs.setRespiratoryrate(vitalSigns.getRespiratoryrate());	
        encounter.setVitalSigns(vs);
        
        session.saveOrUpdate(encounter);
        
        session.getTransaction().commit();
        session.close();
		
	}
	
	
	public VitalSigns getVitalSigns(String patientid,String encounterid,String vswrid)
	{
		int pid = Integer.parseInt(patientid);
		int eid = Integer.parseInt(encounterid);
		int wid = Integer.parseInt(vswrid);
		
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Encounter.class);
		criteria.add(Restrictions.eq("encounterid",eid));
		criteria.add(Restrictions.eq("patient.employeeid",pid));
		
		VitalSignWorkRequest vrequest = (VitalSignWorkRequest) session.get(VitalSignWorkRequest.class, wid);
		vrequest.setWorkrequeststatus("VitalSigns Examined");
		
		Encounter encounter = (Encounter) criteria.uniqueResult();
		
		VitalSigns vs = encounter.getVitalSigns();
		session.getTransaction().commit();
		session.close();
		return vs;
		
		
		
		
	}
	
	

}
