package com.metacube.training.EmployeesPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.EmployeesPortal.model.Employee;
import com.metacube.training.EmployeesPortal.model.JobDetails;

public interface JobDetailsService {

	JobDetails getJobDetailsByEmpCode(String empcode);
	
	boolean updateJobDetailsByEmpCode(JobDetails jobDetails);
}
