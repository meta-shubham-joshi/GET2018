package com.metacube.training.EmployeePortalSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.Job;

public class JobMapper implements RowMapper<Job> {

	public Job mapRow(ResultSet resultSet, int i) throws SQLException {

		Job job = new Job();
		job.setId(resultSet.getInt("job_code"));
		job.setName(resultSet.getString("job_title"));

		return job;
	}

}
