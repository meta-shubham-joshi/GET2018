package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public boolean addEmployee(Employee employee) {
		String employeeCode = (employeeDAO.getLastEmployeeAdded()).getEmpCode();
		String [] employeeCodePartArray = employeeCode.split("/");
		int seriesNumber = Integer.parseInt(employeeCodePartArray[1]);
		seriesNumber = seriesNumber+1;
		employeeCode = employeeCodePartArray[0]+"/"+seriesNumber;
		employee.setEmpCode(employeeCode);
		System.out.println(employee.getEmpCode());
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
