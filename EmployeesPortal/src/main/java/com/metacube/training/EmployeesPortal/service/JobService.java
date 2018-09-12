package com.metacube.training.EmployeesPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeesPortal.dao.EmployeeDAO;
import com.metacube.training.EmployeesPortal.model.Employee;
import com.metacube.training.EmployeesPortal.model.Job;
import com.metacube.training.EmployeesPortal.model.Project;


public interface JobService {
	
	boolean addJob(Job job);
	
	List<Job> getAllJobs();
}
