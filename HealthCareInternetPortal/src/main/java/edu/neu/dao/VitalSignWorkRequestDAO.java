package edu.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.neu.model.VitalSignWorkRequest;

@Repository
public class VitalSignWorkRequestDAO extends DAO{
	
	public List<VitalSignWorkRequest> getVSWRListforNurse(){
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(VitalSignWorkRequest.class);
		criteria.add(Restrictions.eq("workrequeststatus","VitalSigns to be recorded"));
		
		@SuppressWarnings("unchecked")
		List<VitalSignWorkRequest> list = criteria.list();
		 System.out.println("VSR Size List "+list.size());
		 
		 return list;
		
	}
	
	public  List<VitalSignWorkRequest> getVSWRListforDoctor(String loginuser)
	{
		Session session = getSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(VitalSignWorkRequest.class);
		criteria.add(Restrictions.eq("workrequeststatus","VitalSigns recorded"));
		criteria.add(Restrictions.eq("doctorname", loginuser));
		
		@SuppressWarnings("unchecked")
		List<VitalSignWorkRequest> list = criteria.list();
		 System.out.println("VSR Size List "+list.size());
		 
		 return list;
	}

}
