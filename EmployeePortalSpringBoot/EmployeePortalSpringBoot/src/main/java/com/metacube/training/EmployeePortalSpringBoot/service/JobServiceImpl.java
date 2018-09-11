package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.JobDao;
import com.metacube.training.EmployeePortalSpringBoot.model.Job;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDAO;

	@Override
	public boolean addJob(Job job) {
		return jobDAO.createJob(job);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobDAO.getJobs();
	}

}
