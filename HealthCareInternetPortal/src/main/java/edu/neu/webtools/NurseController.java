package edu.neu.webtools;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.model.VitalSignWorkRequest;
import edu.neu.model.VitalSigns;
import edu.neu.service.VSWorkRequestService;
import edu.neu.service.VitalSignsService;
import edu.neu.validator.VitalSignsValidator;

@Controller
@RequestMapping("/nurse")
public class NurseController {
	
	@Autowired
	private VitalSignsValidator vitalSignsValidator;
	
	@Autowired
	private VSWorkRequestService vSWorkRequestService;
	
	@Autowired
	private VitalSignsService vitalSignsService;
	
	@InitBinder
	public void initbinder(WebDataBinder binder)
	{
		binder.setValidator(vitalSignsValidator);
	}
	
	@RequestMapping("/processvsrequest")
	public String getVitalSignProcess(Model model)
	{
		
		List<VitalSignWorkRequest> list=vSWorkRequestService.getVSWRListforNurse();
		
		model.addAttribute("list", list);
		
		
		return "processvsrequest";
	}
	
	
	@RequestMapping(value="/submitvitalsigns",method=RequestMethod.POST)
	public String submitVitalSigns(Model model,@RequestParam("pid")String pid,@RequestParam("eid") String eid, @ModelAttribute("vitalSigns") @Valid VitalSigns vitalSigns,BindingResult result,@RequestParam("vswrid")String vswrid)
	
	
	{
	
		System.out.println("pid in vitalsigns "+pid);
		System.out.println("eid in vitalsigns "+eid);
		
		if(result.hasErrors())
		{
			model.addAttribute("pid", pid);
			model.addAttribute("eid",eid);
			model.addAttribute("vswrid",vswrid);
			return "recordvs";
		}
		System.out.println("pid "+pid);
		System.out.println("eid"+eid);
	
		vitalSignsService.addVitalSigns(pid, eid, vitalSigns,vswrid);
		return "successsubmitvitalsigns";
	}
	
	@RequestMapping("/recordvs")
	public String getVitalSignRecord(Model model,@RequestParam("pid") String pid,@RequestParam("eid") String eid,@RequestParam("vswrid")String vswrid)
	{
		
		model.addAttribute("pid",pid);
		model.addAttribute("eid", eid);
		model.addAttribute("vswrid", vswrid);
		
		System.out.println("pid "+pid);
		System.out.println("eid"+eid);
		
		System.out.println("Work Reqest ID "+vswrid);
	
		return "recordvs";
	}

}
