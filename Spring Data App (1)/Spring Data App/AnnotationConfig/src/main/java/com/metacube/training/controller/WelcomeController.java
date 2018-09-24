package com.metacube.training.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobDetailsService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

@Controller
public class WelcomeController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JobService jobService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private JobDetailsService jobDetailsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "login";
	}
	
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String errorPage(){
		return "error";
	}

	@RequestMapping( value="/default", method=RequestMethod.GET)
	public String afterLogin(HttpServletRequest request){
		
		if(request.isUserInRole("ADMIN")){
			return "redirect:/admin/security";
		}
		return "redirect:/error";
	}
	
}