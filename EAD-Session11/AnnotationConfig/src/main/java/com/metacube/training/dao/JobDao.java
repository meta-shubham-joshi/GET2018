package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobDao {

	boolean createJob(Job job);

	List<Job> getJobs();
}
