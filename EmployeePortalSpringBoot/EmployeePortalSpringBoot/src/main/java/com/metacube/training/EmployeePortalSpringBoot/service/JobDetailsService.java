package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

public interface JobDetailsService {

	JobDetails getJobDetailsByEmpCode(String empcode);

	boolean updateJobDetailsByEmpCode(JobDetails jobDetails);
}
