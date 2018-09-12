package com.metacube.training.EmployeesPortal.dao;

import com.metacube.training.EmployeesPortal.model.JobDetails;
import com.metacube.training.EmployeesPortal.model.Project;

public interface JobDetailsServiceDAO {

	JobDetails getJobDetailsByEmployeeCode(String empCode);
	
	boolean updateJobDetailsByEmployeeCode(JobDetails jobDetails);
}
