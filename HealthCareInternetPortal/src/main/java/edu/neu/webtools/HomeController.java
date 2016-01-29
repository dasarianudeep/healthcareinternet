package edu.neu.webtools;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.dao.HibernateUtil;
import edu.neu.model.Encounter;
import edu.neu.model.Medication;
import edu.neu.model.Patient;
import edu.neu.model.VitalSigns;
import edu.neu.service.UseraccountService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UseraccountService useraccountService;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,@CookieValue(value="mycookie",required=false)String mycookie,@CookieValue(value="cookiepwd",required=false)String cookiepwd,HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("mycookie name "+mycookie);
		System.out.println("my session "+session);
		//model.addAttribute("useraccount", new Useraccount());
		if(mycookie!=null && cookiepwd!=null)
		{
			String role=useraccountService.authenticateUser(mycookie, cookiepwd);
			return role+"homepage";
			
		}
		
		
		return "login";
	}
	
	@RequestMapping("/userlogout")
	public String logout(Model model,HttpSession session)
	{
		session.invalidate();
		//model.addAttribute("name", "anudeep");
		return "login";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String getHomepage(Model model,@RequestParam("username")String username,@RequestParam("password")String password,HttpServletRequest request,@RequestParam(value="remember",required=false)String remember,HttpServletResponse response,HttpSession session)
	{
		if(session==null)
		{
			return "login";
		}
		if(remember!=null)
		{
			System.out.println("In cookie");
			Cookie cookie1 = new Cookie("mycookie",username);
			Cookie cookie2 = new Cookie("cookiepwd",password);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		}
		String role=useraccountService.authenticateUser(username, password);
		
		if(role==null)
		{
			model.addAttribute("error", "Invalid user/password credentials");
			return "login";
		}
		
		 session= request.getSession();
		session.setAttribute("loginuser", username);
		
		
		
		return role+"homepage";
	}
	
	@RequestMapping(value="/signuppatient",method=RequestMethod.GET)
	public String getPatientRegistration(Model model)
	{
		
		return "patientregistration";
	}
	
	@RequestMapping(value="/registerpatient",method=RequestMethod.POST)
	public String getPatientRegistrationForm(Model model,@Valid @ModelAttribute("patient") Patient patient,BindingResult result/*@RequestParam String city,@RequestParam String gender,@RequestParam int ssn,@RequestParam int age,@RequestParam String firstname,@RequestParam String lastname*/)
	{
		
		if(result.hasErrors())
		{
			System.out.println("innnnn");
			return "patientregistration";
		}
		
		System.out.println("IN Patient"+patient.getAge());
		//patientService.addPatient(patient);
		useraccountService.addPatientUseraccount(patient.getUseraccount(), patient.getCity(), patient.getGender(), patient.getSsn(), patient.getAge(), patient.getFirstname(), patient.getLastname());
		return "successaddpatient";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String handleExceptions(Model model,HttpServletRequest request,Exception e)
	{
		Map<String,Object> exceptionmap = new HashMap<String,Object>();
		exceptionmap.put("uri", request.getRequestURI());
		exceptionmap.put("exception", e);
		exceptionmap.put("exceptionclass",e.getClass().getSimpleName());
		model.addAllAttributes(exceptionmap);
		return "mvcexception";
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String addEncounter()
	{
		
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	s.beginTransaction();
	
	Patient p = (Patient) s.get(Patient.class, 1);
	
	Encounter e = new Encounter();
	e.setPatient(p);
	p.getEncounterslist().add(e);
	
	s.saveOrUpdate(p);
	
	
	s.getTransaction().commit();
	s.close();
	
	int id = e.getEncounterid();
	System.out.println("Encounter id "+id);
	return "display";
	
	
		
	}
	
	@RequestMapping(value="/submitvitalsigns",method=RequestMethod.POST)
	public String addVitalSigns()
	{
		
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	s.beginTransaction();
	
	Encounter e = (Encounter) s.get(Encounter.class, 1);
	
	VitalSigns vs = new VitalSigns();
	vs.setBloodpressure(100);
	vs.setBodytemperature(120);
	vs.setPulserate(200);
	vs.setRespiratoryrate(1211);
	e.setVitalSigns(vs);
	
	s.save(vs);
	s.saveOrUpdate(e);
	
	s.getTransaction().commit();
	s.close();
	return "display";
	
	
		
	}
	
	@RequestMapping(value="/submitmedicationlist",method=RequestMethod.POST)
	public String addMedication()
	{
		
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	s.beginTransaction();
	
	Encounter e = (Encounter) s.get(Encounter.class, 1);
	
	Medication m = new Medication();
	m.setDrugname("calpol");
	m.setDrugdosage("400");
	m.setQuantity("10");
	m.setAdvice("my advice");
	m.setEncounter(e);
	
	
	Medication m2 = new Medication();
	m2.setDrugname("calpol");
//	m2.setDrugdosage(400);
//	m2.setQuantity(10);
//	m2.setAdvice("my advice");
//	m2.setEncounter(e);
	
	e.getMedicationlist().add(m);
	e.getMedicationlist().add(m2);
	s.saveOrUpdate(e);
	
	s.getTransaction().commit();
	s.close();
	return "display";
	
	
		
	}
	
	

	
}
