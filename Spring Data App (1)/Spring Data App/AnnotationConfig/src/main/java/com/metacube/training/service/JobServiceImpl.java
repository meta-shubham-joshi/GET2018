package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.repository.JobServiceRepository;
import com.metacube.training.repository.ProjectRepository;

@Service
public class JobServiceImpl implements JobService {
/*
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
	
	*/
	@Autowired
    private JobServiceRepository<Job> jobServiceRepository;

	@Override
	public List<Job> getAllJobs() {
		return jobServiceRepository.findAll();
	}

	@Override
	public boolean addJob(Job job) {		
		jobServiceRepository.save(job);		
		return true;
	}


}
