package com.metacube.training.EmployeesPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeesPortal.dao.EmployeeDAO;
import com.metacube.training.EmployeesPortal.dao.JobDao;
import com.metacube.training.EmployeesPortal.dao.ProjectDAO;
import com.metacube.training.EmployeesPortal.model.Job;

@Service
public class JobServiceImpl implements JobService{

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
