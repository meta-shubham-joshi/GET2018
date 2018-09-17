package com.metacube.training.EmployeesPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeesPortal.model.Employee;
import com.metacube.training.EmployeesPortal.model.Project;
import com.metacube.training.EmployeesPortal.model.Skill;
import com.metacube.training.EmployeesPortal.service.EmployeeService;
import com.metacube.training.EmployeesPortal.service.ProjectService;
import com.metacube.training.EmployeesPortal.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}


	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null && project.getId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		// redirect is used to send the get request. if not used then it means it is a post request.
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("projectId") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("projectId") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(path = "/skills/showskills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skillShow";
	}
	
	
	@RequestMapping(path = "/skills/addskill", method = RequestMethod.GET)
	public String addSkill(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/skill";
	}
	
	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkills(@ModelAttribute("skill") Skill skill) {
		
		if(skill!= null) {
			skillService.createSkill(skill);	
		}
		//redirect is used to send the get request. if not used then it means it is a post request.
		return "redirect:/admin/skills/showskills";
	}
	
	/**
	 * Add employee
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/employee/addemployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/employee";
	}
	
	/**
	 * Added employee saved to the database.
	 * @param skill
	 * @return
	 */
	@RequestMapping(path = "/employee/addemployee", method = RequestMethod.POST)
	public String addemployees(@ModelAttribute("employee") Employee employee) {
		
		if(employee!= null) {
			employeeService.addEmployee(employee);	
		}
		//redirect is used to send the get request. if not used then it means it is a post request.
		return "redirect:/admin/employeeShow";
	}
	
	
	/*
	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String addSkill(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}*/

}
