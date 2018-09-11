package com.metacube.training.EmployeesPortal.dao;

import java.util.List;

import com.metacube.training.EmployeesPortal.model.Employee;
import com.metacube.training.EmployeesPortal.model.Job;

public interface JobDao {
	
	boolean createJob(Job job);

	List<Job> getJobs();
}
