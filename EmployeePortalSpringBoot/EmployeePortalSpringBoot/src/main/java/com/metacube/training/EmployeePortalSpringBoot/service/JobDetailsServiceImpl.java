package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.JobDetailsServiceDAO;
import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsServiceDAO jobDetailsServiceDAO;

	@Override
	public JobDetails getJobDetailsByEmpCode(String empcode) {
		return jobDetailsServiceDAO.getJobDetailsByEmployeeCode(empcode);
	}

	@Override
	public boolean updateJobDetailsByEmpCode(JobDetails jobDetails) {
		return jobDetailsServiceDAO.updateJobDetailsByEmployeeCode(jobDetails);
	}

}
