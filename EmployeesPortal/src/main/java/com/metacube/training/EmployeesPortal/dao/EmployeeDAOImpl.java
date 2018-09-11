package com.metacube.training.EmployeesPortal.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeesPortal.mappers.EmployeeMapper;
import com.metacube.training.EmployeesPortal.mappers.ProjectMapper;
import com.metacube.training.EmployeesPortal.mappers.ValidateMapper;
import com.metacube.training.EmployeesPortal.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_INSERT_Employee = "insert into employee(emp_code,first_name,last_name,dob,gender,primary_contact_number,secondary_contact_number,email_id, skype_id,profile_picture,password,enabled) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_FIND_EMPLOYEE = "select * FROM employee where emp_code=?";
	private final String SQL_VALIDATE_CREDENTIALS = "select password from employee where emp_code = ?";
	
	@Override
	public boolean createEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_Employee, employee.getEmpCode(), employee.getFirstName(), employee.getLastName(), employee.getDob(), employee.getGender(), employee.getPrimary_contact_number(), employee.getSecondary_contact_number(), employee.getEmail_id(),employee.getSkype_id(),employee.getProfile_picture(),employee.getPassword(),employee.getEnabled()
				) > 0;
	}


	@Override
	public List<Employee> getEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}


	@Override
	public Employee getEmployeeDetailsByEmpCode(String empCode) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { empCode }, new EmployeeMapper());
	}


	@Override
	public Employee validateCredentials(String emp_code) {
		return jdbcTemplate.queryForObject(SQL_VALIDATE_CREDENTIALS, new Object[] { emp_code }, new ValidateMapper());
	}

}
