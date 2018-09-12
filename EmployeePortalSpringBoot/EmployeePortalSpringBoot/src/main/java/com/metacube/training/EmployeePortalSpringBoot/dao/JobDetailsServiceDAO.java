package com.metacube.training.EmployeePortalSpringBoot.dao;

import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

public interface JobDetailsServiceDAO {

	JobDetails getJobDetailsByEmployeeCode(String empCode);

	boolean updateJobDetailsByEmployeeCode(JobDetails jobDetails);
}
