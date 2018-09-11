package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalSpringBoot.mappers.JobMapper;
import com.metacube.training.EmployeePortalSpringBoot.model.Job;

@Repository
public class JobDaoImpl implements JobDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_INSERT_Job = "insert into job_title_master(job_title) values(?)";
	private final String SQL_GET_ALL = "select * from job_title_master";

	@Override
	public boolean createJob(Job job) {

		return jdbcTemplate.update(SQL_INSERT_Job, job.getName()) > 0;
	}

	@Override
	public List<Job> getJobs() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
	}

}
