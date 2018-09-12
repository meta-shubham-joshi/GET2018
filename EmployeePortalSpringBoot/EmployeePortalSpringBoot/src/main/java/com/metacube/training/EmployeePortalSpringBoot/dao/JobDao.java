package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Job;

public interface JobDao {

	boolean createJob(Job job);

	List<Job> getJobs();
}
