package com.metacube.training.EmployeePortalSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

public class JobDetailsMapper implements RowMapper<JobDetails> {

	public JobDetails mapRow(ResultSet resultSet, int i) throws SQLException {

		JobDetails jobDetails = new JobDetails();

		jobDetails.setJob_detail_id(resultSet.getString("job_detail_id"));
		jobDetails.setEmp_code(resultSet.getString("emp_code"));
		jobDetails.setDate_of_joining(resultSet.getDate("date_of_joining"));
		jobDetails.setTotal_exp(resultSet.getInt("total_exp"));
		jobDetails.setJob_code(resultSet.getInt("job_code"));
		jobDetails.setReporting_mgr(resultSet.getString("reporting_mgr"));
		jobDetails.setTeam_lead(resultSet.getString("team_lead"));
		jobDetails.setCurr_proj_id(resultSet.getInt("curr_proj_id"));

		return jobDetails;
	}
}
