package edu.neu.webtools;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.model.Useraccount;
import edu.neu.service.UseraccountService;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UseraccountService useraccountService;
	
	
	@RequestMapping("/home")
	public String getAdminHomepage()
	{
		return "adminhomepage";
		
	}
	
	@RequestMapping(value="/manageemployees",method=RequestMethod.GET)
	public String getManageEmployees(Model model) throws NumberFormatException
	{
		
	
		throw  new NumberFormatException();
		//return "manageemployees";
		
	}
	
	@RequestMapping(value="/addemployees",method=RequestMethod.POST)
	public String getAddEmployee(Model model,@Valid @ModelAttribute("useraccount")Useraccount useraccount,BindingResult result)
	{
		if(result.hasErrors())
		{
			
			return "manageemployees";
		}
		else
		
		{
			System.out.println("going to dao");
			model.addAttribute("role", useraccount.getRole());
			useraccountService.addUseraccount(useraccount);
			
			return "successaddemployee";
		}
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public String handleExceptions(Model model,HttpServletRequest request,Exception e)
	{
		Map<String,Object> exceptionmap = new HashMap<String,Object>();
		exceptionmap.put("uri", request.getRequestURI());
		exceptionmap.put("exception", e);
		exceptionmap.put("exceptionclass",e.getClass().getSimpleName());
		model.addAllAttributes(exceptionmap);
		//ModelAndView mav = new ModelAndView("mvcexception");
		return "mvcexception";
	}
	
}
