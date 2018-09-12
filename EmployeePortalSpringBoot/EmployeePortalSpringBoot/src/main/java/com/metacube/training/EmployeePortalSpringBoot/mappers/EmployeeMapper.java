package com.metacube.training.EmployeePortalSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setEmpCode(resultSet.getString("emp_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setPrimary_contact_number(resultSet
				.getString("primary_contact_number"));
		employee.setSecondary_contact_number(resultSet
				.getString("secondary_contact_number"));
		employee.setEmail_id(resultSet.getString("email_id"));
		employee.setSkype_id(resultSet.getString("skype_id"));
		employee.setProfile_picture(resultSet.getString("profile_picture"));
		employee.setPassword(resultSet.getString("password"));
		employee.setEnabled(resultSet.getBoolean("enabled"));

		return employee;
	}
}
