package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Job;

public interface JobService {

	boolean addJob(Job job);

	List<Job> getAllJobs();
}
