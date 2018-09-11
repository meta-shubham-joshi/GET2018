package com.metacube.training.EmployeePortalSpringBoot.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalSpringBoot.mappers.JobDetailsMapper;
import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

@Repository
public class JobDetailsServiceDAOImpl implements JobDetailsServiceDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDetailsServiceDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_JOBDETAILS = "select * from job_detail where  emp_code  = ?";
	private final String SQL_UPDATE_JOB_DETAILS = "update job_detail set date_of_joining = ?, total_exp  = ?, job_code  = ?, reporting_mgr= ?, team_lead= ?, curr_proj_id= ? where emp_code = ?";

	@Override
	public JobDetails getJobDetailsByEmployeeCode(String empCode) {

		JobDetails jobDetails = null;
		try {
			jobDetails = jdbcTemplate.queryForObject(SQL_FIND_JOBDETAILS,
					new Object[] { empCode }, new JobDetailsMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			jobDetails = new JobDetails();
			jobDetails.setEmp_code(empCode);
		}
		return jobDetails;

	}

	@Override
	public boolean updateJobDetailsByEmployeeCode(JobDetails jobDetails) {
		return jdbcTemplate.update(SQL_UPDATE_JOB_DETAILS,
				jobDetails.getDate_of_joining(), jobDetails.getTotal_exp(),
				jobDetails.getJob_code(), jobDetails.getReporting_mgr(),
				jobDetails.getTeam_lead(), jobDetails.getCurr_proj_id(),
				jobDetails.getEmp_code()) > 0;
	}

}
