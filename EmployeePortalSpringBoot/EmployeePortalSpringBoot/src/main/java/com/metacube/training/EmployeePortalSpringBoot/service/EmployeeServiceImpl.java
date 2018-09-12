package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.EmployeeDAO;
import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	public Employee getEmployeeById(String emp_code) {
		return employeeDAO.getEmployeeDetailsByEmpCode(emp_code);
	}

	@Override
	public Employee ValidateUser(String emp_code) {
		return employeeDAO.validateCredentials(emp_code);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployeePasswordInDatabase(employee);
	}

}
