package edu.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.neu.model.Encounter;
import edu.neu.model.LabTestWorkRequest;
import edu.neu.model.VitalSignWorkRequest;
import edu.neu.model.VitalSigns;

@Repository
public class LabTestWorkRequestDAO extends DAO{
	
	public void sendToLab(String pid,String eid,String loginuser,String vitalSignObservations)
	{
		LabTestWorkRequest ltworkrequest = new LabTestWorkRequest();
		ltworkrequest.setDoctorname(loginuser);
		ltworkrequest.setLabassistantname("Not Assigned");
		ltworkrequest.setPatientid(Integer.parseInt(pid));
		ltworkrequest.setEncounterid(Integer.parseInt(eid));
		ltworkrequest.setWorkrequeststatus("Labresults to be Recorded");
		
		Session session= getSession();
		session.beginTransaction();
		int patientid = Integer.parseInt(pid);
		int encounterid = Integer.parseInt(eid);
		
		 Query query = session.createQuery("from Encounter e where e.patient.employeeid=:patientid and e.encounterid=:encounterid");
		 query.setParameter("patientid", patientid);
		 query.setParameter("encounterid", encounterid);
				Encounter encounter = (Encounter) query.uniqueResult();
				
				encounter.setVitalSignObservations(vitalSignObservations);
				session.saveOrUpdate(encounter);
				
				
		session.save(ltworkrequest);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	public List<LabTestWorkRequest> getVSWRListforNurse()
	{
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(LabTestWorkRequest.class);
		criteria.add(Restrictions.eq("workrequeststatus","Labresults to be Recorded"));
		
		List<LabTestWorkRequest> list = criteria.list();
		System.out.println("LT Nurse list"+list.size());
		return list;
		
	}
	
	public List<LabTestWorkRequest> getLabRequestsforDoctor(String loginuser)
	{
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria  = session.createCriteria(LabTestWorkRequest.class);
		criteria.add(Restrictions.eq("workrequeststatus","Labresults Recorded"));
		criteria.add(Restrictions.eq("doctorname",loginuser));
		
		List<LabTestWorkRequest> list = criteria.list();
		
		System.out.println("LT Doctor list"+list.size());
		return list;
		
		
		
	}
	
	public List<LabTestWorkRequest> getLabRequestsforLabAssitant()
	{
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria  = session.createCriteria(LabTestWorkRequest.class);
		criteria.add(Restrictions.eq("workrequeststatus","Labresults to be Recorded"));

		
		List<LabTestWorkRequest> list = criteria.list();
		
		System.out.println("LT Doctor list"+list.size());
		return list;
		
		
		
	}
	
	public void addLabResults(String pid,String eid,String ltwid,String labTestType,String labTestResults)
	{
		Session session= getSession();
		session.beginTransaction();
		
		int patientid = Integer.parseInt(pid);
		int encounterid = Integer.parseInt(eid);
		int lid = Integer.parseInt(ltwid);
		
		System.out.println("patientid "+patientid);
		System.out.println("encounterid "+encounterid);
		
		LabTestWorkRequest ltwr = (LabTestWorkRequest) session.get(LabTestWorkRequest.class, lid);
		ltwr.setWorkrequeststatus("Labresults Recorded");
		//vsr.setNursename("");
//		Criteria criteria = session.createCriteria(Encounter.class,"encounter");
//		criteria.add(Restrictions.eq("encounterid",encounterid));
//		criteria.add(Restrictions.eq("encounter.patient",patientid));
		
 Query query = session.createQuery("from Encounter e where e.patient.employeeid=:patientid and e.encounterid=:encounterid");
 query.setParameter("patientid", patientid);
 query.setParameter("encounterid", encounterid);
		Encounter encounter = (Encounter) query.uniqueResult();
		encounter.setLabTestResults(labTestResults);
		encounter.setLabTestType(labTestType);
		
		
        session.saveOrUpdate(encounter);
        
        session.getTransaction().commit();
        session.close();
	}
	
	public Encounter getLabResults(String patientid,String encounterid,String ltwrid)
	{
		int pid = Integer.parseInt(patientid);
		int eid = Integer.parseInt(encounterid);
		int lid = Integer.parseInt(ltwrid);
		
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Encounter.class);
		criteria.add(Restrictions.eq("encounterid",eid));
		criteria.add(Restrictions.eq("patient.employeeid",pid));
		
		LabTestWorkRequest lrequest = (LabTestWorkRequest) session.get(LabTestWorkRequest.class, lid);
		lrequest.setWorkrequeststatus("Labresults Analyzed");
		
		Encounter encounter = (Encounter) criteria.uniqueResult();
		
		
		session.getTransaction().commit();
		session.close();
		return encounter;
		
		
		
		
	}
	

}
