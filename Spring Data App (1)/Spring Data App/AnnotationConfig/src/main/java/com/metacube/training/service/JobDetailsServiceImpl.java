package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailsRepository;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsRepository<JobDetails> jobDetailsRepository;

	@Override
	public JobDetails getJobDetailsByEmpCode(String empcode) {

		JobDetails jobDetails = null;
		try {
			jobDetails = jobDetailsRepository.findJobDetailsByEmpCode(empcode);
			if (jobDetails == null) {
				jobDetails = new JobDetails();
				jobDetails.setEmp_code(empcode);
			}
		} catch (IllegalStateException e) {

		}
		return jobDetails;
	}

	@Override
	public boolean updateJobDetailsByEmpCode(JobDetails jobDetails) {
		return jobDetailsRepository.updateJobDetailsInfo(
				jobDetails.getDate_of_joining(), jobDetails.getTotal_exp(),
				jobDetails.getJob_code(), jobDetails.getReporting_mgr(),
				jobDetails.getTeam_lead(), jobDetails.getCurr_proj_id(),
				jobDetails.getEmp_code(), jobDetails.getJob_detail_id()) > 0;
	}

}
