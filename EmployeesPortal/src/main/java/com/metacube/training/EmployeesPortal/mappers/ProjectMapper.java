package com.metacube.training.EmployeesPortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeesPortal.model.Project;


public class ProjectMapper implements RowMapper<Project> {

	public Project mapRow(ResultSet resultSet, int i) throws SQLException {

		Project project = new Project();
		project.setId(resultSet.getInt("project_id"));
		project.setName(resultSet.getString("project_name"));
		project.setDescription(resultSet.getString("project_description"));
		project.setStartDate(resultSet.getDate("start_date"));
		project.setEndDate(resultSet.getDate("end_date"));
		return project;
	}
}
