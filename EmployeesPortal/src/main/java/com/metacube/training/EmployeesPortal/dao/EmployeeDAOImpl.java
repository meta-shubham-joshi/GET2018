package com.metacube.training.EmployeesPortal.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeesPortal.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_INSERT_Employee = "insert into employee(emp_code,first_name,last_name,dob,gender,primary_contact_number,secondary_contact_number,email_id, skype_id,profile_picture,password,enabled) values(?,?,?,?,?,?,?,?,?,?,?,?)";

	
	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_Employee, employee.getEmpCode(), employee.getFirstName(), employee.getLastName(), employee.getDob(), employee.getGender(), employee.getPrimary_contact_number(), employee.getSecondary_contact_number(), employee.getEmail_id(),employee.getSkype_id(),employee.getProfile_picture(),employee.getPassword(),employee.getEnabled()
				) > 0;
	}

}
