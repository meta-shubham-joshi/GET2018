package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {

	boolean addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String emp_code);

	//Employee ValidateUser(String emp_code);

	boolean updateEmployee(Employee employee);
}
