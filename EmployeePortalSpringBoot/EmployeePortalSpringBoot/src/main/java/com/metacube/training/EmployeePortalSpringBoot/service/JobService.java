package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.model.Job;

public interface JobService {

	boolean addJob(Job job);

	List<Job> getAllJobs();
}
