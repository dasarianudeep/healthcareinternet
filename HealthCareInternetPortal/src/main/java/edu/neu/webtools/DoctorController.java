package edu.neu.webtools;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.model.Encounter;
import edu.neu.model.LabTestWorkRequest;
import edu.neu.model.Medication;
import edu.neu.model.VitalSignWorkRequest;
import edu.neu.model.VitalSigns;
import edu.neu.service.EncounterService;
import edu.neu.service.LabWorkRequestService;
import edu.neu.service.MedicationWorkRequestService;
import edu.neu.service.VSWorkRequestService;
import edu.neu.service.VitalSignsService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	//@Autowired
	//private EmployeeValidator employeeValidator;
	
	@Autowired
	private EncounterService encounterService;
	
	@Autowired
	private VSWorkRequestService vsworkrequestService;
	
	@Autowired
	private VitalSignsService vitalsignsService;
	
	@Autowired
	private LabWorkRequestService labWorkRequestService;
	
	@Autowired
	private MedicationWorkRequestService medicationWorkRequestService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		
		binder.registerCustomEditor(Integer.class, null,new CustomNumberEditor(Integer.class,true));
	}
	
	@RequestMapping("/diagnosepatient")
	public String getPatientDiagnosis(Model model)
	{
		
		return "diagnosepatient";
	}
	
	
	@RequestMapping(value="/successvitalsigns", method=RequestMethod.POST)
	public String sendToNurse(Model model,@Valid @ModelAttribute("encounter") Encounter encounter,BindingResult result,HttpServletRequest request)
	{
		System.out.println("Patient id   "+encounter.getPatient().getEmployeeid());
		
		//System.out.println("Patient id   "+patientid);
		if(result.hasErrors())
		{
			return "diagnosepatient";
		}
		System.out.println("Patient id   "+encounter.getPatient().getEmployeeid());
		System.out.println("Encounter   "+encounter.getIsAlcoholic());
		
		String loginuser = (String) request.getSession().getAttribute("loginuser");
		
		System.out.println("Logged in user "+loginuser);
		
		encounterService.createEncounter(String.valueOf(encounter.getPatient().getEmployeeid()), encounter,loginuser);
		
		
		return "successvitalsigns";
	}
	
	@RequestMapping(value="/sendtolabanalysis",method=RequestMethod.POST)
	public String sendToLab(Model model,@RequestParam("pid")String pid,HttpServletRequest request,@RequestParam("eid")String eid,@RequestParam("vitalSignObservations")String vitalSignObservations)
	{
		
		String loginuser = (String) request.getSession().getAttribute("loginuser");
		System.out.println("ppid "+pid);
		System.out.println("user  "+loginuser);
		labWorkRequestService.sendToLab(pid, eid, loginuser,vitalSignObservations);
		
	    return "successsendtolab";
		
	}
	
	
	
	
	@RequestMapping("/examinevitalsigns")
	public String getVitalSignExamination(Model model,HttpServletRequest request)
	{
		String loginuser = (String) request.getSession().getAttribute("loginuser");
		List<VitalSignWorkRequest> list = vsworkrequestService.getVSWRListforDoctor(loginuser);
		
		model.addAttribute("list", list);
		
		return "examinevitalsigns";
	}
	
	@RequestMapping("/analyzelabresults")
	public String getLabResultAnalysis(Model model,HttpServletRequest request)
	{
		String loginuser = (String) request.getSession().getAttribute("loginuser");
	
		List<LabTestWorkRequest> list = labWorkRequestService.getLabRequestsforDoctor(loginuser);
		model.addAttribute("list", list);
		
		return "analyzelabresults";
		
	}
	
	@RequestMapping("/viewlabresults")
	public String getViewLabResults(Model model,@RequestParam("pid")String pid,@RequestParam("eid")String eid,@RequestParam("ltwrid")String ltwrid)
	{
		Encounter e = labWorkRequestService.getLabResults(pid, eid, ltwrid);
		model.addAttribute("e", e);
		model.addAttribute("pid", pid);
		model.addAttribute("eid", eid);
		
		return "viewlabresults";
	}
	
	@RequestMapping("/suggestmedication")
	public String prescribeMedication(Model model,@RequestParam("pid")String pid,@RequestParam("eid")String eid)
	{
		
		model.addAttribute("pid", pid);
		model.addAttribute("eid", eid);
		return "suggestmedication";
	}

@RequestMapping(value="/sendtopharmacy",method=RequestMethod.POST)
	public String getMedicationSuggestion(Model model,HttpServletRequest request,@RequestParam("pid")String pid,@RequestParam("eid")String eid,/*@RequestParam("drugname")String drugname,@RequestParam("drugdosage")String drugdosage,@RequestParam("quantity")String quantity,@RequestParam("advice")String advice*/@Valid @ModelAttribute("medication")Medication medication,BindingResult result )
	{
	
	System.out.println("name "+medication.getDrugname());
	System.out.println("quantiry"+medication.getQuantity());
	if(result.hasErrors())
	{
		model.addAttribute("pid",pid);
		model.addAttribute("eid",eid);
		return "suggestmedication";
	}
	HttpSession session = request.getSession();
	String loginuser = (String) session.getAttribute("loginuser");
	medicationWorkRequestService.addMedication(pid, eid, medication.getDrugname(), medication.getDrugdosage(), medication.getQuantity(), medication.getAdvice(),loginuser);
		return "successmedication";
		
	}
	
	@RequestMapping("/viewvs")
	public String getVitalSignRecords(Model model,@RequestParam("pid")String pid,@RequestParam("eid")String eid,@RequestParam("vswrid")String vswrid)
	{

		VitalSigns vitalsigns = vitalsignsService.getVitalSigns(pid, eid,vswrid);
		model.addAttribute("vitalsigns", vitalsigns);
		model.addAttribute("pid", pid);
		model.addAttribute("eid", eid);
		return "viewvs";
	}
	

}
