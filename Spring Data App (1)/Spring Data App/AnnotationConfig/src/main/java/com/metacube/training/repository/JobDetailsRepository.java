package com.metacube.training.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

@Repository
@Transactional
public interface JobDetailsRepository<JD> extends
		JpaRepository<JobDetails, Integer> {

	// @Modifying(clearAutomatically = true)
	@Query("FROM JobDetails WHERE emp_code = ?1")
	JobDetails findJobDetailsByEmpCode(String empCode);

	@Modifying(clearAutomatically = true)
	@Query("update JobDetails jobDetails set jobDetails.date_of_joining = ?1, jobDetails.total_exp = ?2, jobDetails.job_code = ?3, jobDetails.reporting_mgr = ?4, jobDetails.team_lead = ?5, jobDetails.curr_proj_id = ?6, jobDetails.emp_code = ?7 where jobDetails.job_detail_id = ?8")
	int updateJobDetailsInfo(Date date_of_joining, int total_exp, int job_code,
			String reporting_mgr, String team_lead, int curr_proj_id,
			String emp_code, int id);

}
