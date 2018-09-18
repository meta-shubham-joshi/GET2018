package com.metacube.training.dao;

import com.metacube.training.model.JobDetails;

public interface JobDetailsServiceDAO {

	JobDetails getJobDetailsByEmployeeCode(String empCode);

	boolean updateJobDetailsByEmployeeCode(JobDetails jobDetails);
}
