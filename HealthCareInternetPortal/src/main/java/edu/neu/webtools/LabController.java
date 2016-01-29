package edu.neu.webtools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.model.Encounter;
import edu.neu.model.LabTestWorkRequest;
import edu.neu.service.LabWorkRequestService;


@Controller
@RequestMapping("/lab")
public class LabController {
	
	@Autowired
	private LabWorkRequestService labWorkRequestService;
	
	
	
	@RequestMapping("/processlabrequests")
	public String getLabtestRequest(Model model)
	{
		
		List<LabTestWorkRequest> list = labWorkRequestService.getLabRequestsforLA();
		model.addAttribute("list", list);
		return "processlabrequests";
	}
	
	@RequestMapping(value="/peformlabtests")
	public String getPerformLabTests(Model model,@RequestParam("pid")String pid,@RequestParam("eid")String eid,@RequestParam("ltwid")String ltwid)
	{
		model.addAttribute("pid", pid);
		model.addAttribute("eid", eid);
		model.addAttribute("ltwid", ltwid);
		
		return "performlabtests";
	}
	
	@RequestMapping("/submitlabresults")
	public String getSubmitResults(Model model,@RequestParam("pid")String pid,@RequestParam("eid")String eid,@RequestParam("ltwid")String ltwid,@RequestParam("labTestType")String labTestType,@RequestParam("labTestResults")String labTestResults)
	
	{
		System.out.println("pid in lab "+pid);
		System.out.println("eid in lab "+eid);
//		System.out.println(encounter.getLabTestType());
//		System.out.println(encounter.getLabTestResults());
//		if(result.hasErrors())
//		{
//			model.addAttribute("pid",pid);
//			model.addAttribute("eid",eid);
//			model.addAttribute("ltwid", ltwid);
//			return "performlabtests";
//		}
		
		labWorkRequestService.addLabResults(pid, eid, ltwid,labTestType, labTestResults);
		
		return "successsubmitlabresults";
	}
	
}

