package com.metacube.training.EmployeesPortal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeesPortal.model.Employee;
import com.metacube.training.EmployeesPortal.model.Job;
import com.metacube.training.EmployeesPortal.model.JobDetails;
import com.metacube.training.EmployeesPortal.model.Project;
import com.metacube.training.EmployeesPortal.model.Skill;
import com.metacube.training.EmployeesPortal.service.EmployeeService;
import com.metacube.training.EmployeesPortal.service.JobDetailsService;
import com.metacube.training.EmployeesPortal.service.JobService;
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

	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobDetailsService jobDetailsService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam(name="username") String emp_code, @RequestParam(name="password") String password,
			HttpServletRequest request){
		if(employeeService.ValidateUser(emp_code).getPassword().equals(password)){
			request.getSession().setAttribute("empCode", emp_code);
			return new ModelAndView("admin/dashboard", "username", emp_code);
		}else{
			return new ModelAndView("admin/error");
		}
	}
/**
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}
**/
	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == 0) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		// redirect is used to send the get request. if not used then it means
		// it is a post request.
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

		if (skill != null) {
			skillService.createSkill(skill);
		}
		// redirect is used to send the get request. if not used then it means
		// it is a post request.
		return "redirect:/admin/skills/showskills";
	}

	/**
	 * Add employee
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/employee/addemployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/employee";
	}
	
	@RequestMapping(path = "/employeeShow", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "admin/employeeShow";
	}


	/**
	 * Added employee saved to the database.
	 * 
	 * @param skill
	 * @return
	 */
	@RequestMapping(path = "/employees/addemployee", method = RequestMethod.POST)
	public String addemployees(@ModelAttribute("employee") Employee employee) {

		if (employeeService.addEmployee(employee)) {
			System.out.println("Successfully Added");
		}else{
			System.out.println("Not Added Successfully");
		}
		// redirect is used to send the get request. if not used then it means
		// it is a post request.
		return "redirect:/admin/employeeShow";
	}
	
	

	/**
	 * Add Jobs with Get Request.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/job/addjob", method = RequestMethod.GET)
	public String addJobs(Model model) {
		model.addAttribute("job", new Job());
		return "admin/job";
	}
	
	/**
	 * Method to get all the jobs.
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/alljobs", method = RequestMethod.GET)
	public String getAllJobs(Model model) {
		model.addAttribute("job", jobService.getAllJobs());
		return "admin/jobShow";
	}

	/**
	 * Add Jobs with Post Request.
	 * 
	 * @param job
	 * @return
	 */
	@RequestMapping(path = "/job/addjob", method = RequestMethod.POST)
	public String addJob(@ModelAttribute("job") Job job) {

		if (job != null) {
			jobService.addJob(job);
		}
		// redirect is used to send the get request. if not used then it means
		// it is a post request.
		return "redirect:/admin/alljobs";
	}
	
	/*
	@RequestMapping(path = "/editJobDetails", method = RequestMethod.GET)
	public String editJobDetails(Model model, @RequestParam("projectId") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}*/
	
	@RequestMapping(path = "/employee/edit", method = RequestMethod.GET)
	public String editEmployeeDetails(Model model, @RequestParam("empCode") String employeeCode) {
		model.addAttribute("JobDetails", jobDetailsService.getJobDetailsByEmpCode(employeeCode));
		return "admin/editJobDetails";
	}
	
	/** My version of edit
	@RequestMapping(path = "/employees/edit", method = RequestMethod.POST)
	public String editEmployeesDetails(Model model, @RequestParam("JobDetails") JobDetails jobDetails) {
		model.addAttribute("JobDetails", jobDetailsService.updateJobDetailsByEmpCode(jobDetails));
		return "redirect:/admin/employeeShow";
	}
	 **/
	
	
	@RequestMapping(path = "/employees/edit", method = RequestMethod.POST)
	public String editEmployeesDetails(@ModelAttribute("JobDetails") JobDetails jobDetails) {
		if (jobDetails!= null) {
			jobDetailsService.updateJobDetailsByEmpCode(jobDetails);
		}
		// redirect is used to send the get request. if not used then it means
		// it is a post request.
		return "redirect:/admin/employeeShow";
	}
	
	
	
	
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String searchEmployee(Model model) {
	return "admin/search";
	}
	

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String employeeCode,  Model model) {
	model.addAttribute("employee",employeeService.getEmployeeById(employeeCode));
	return "admin/search";
	}
	
	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "admin/login";
	}

}
