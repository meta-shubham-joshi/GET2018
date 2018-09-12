package com.metacube.training.EmployeesPortal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeesPortal.model.Employee;

public class ValidateMapper implements RowMapper<Employee>{
	
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setPassword(resultSet.getString("password"));
		
		return employee;
	}

}
