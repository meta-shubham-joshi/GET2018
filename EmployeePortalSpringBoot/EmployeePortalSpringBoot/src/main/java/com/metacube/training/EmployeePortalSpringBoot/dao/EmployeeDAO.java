package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

public interface EmployeeDAO {

	boolean createEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployeeDetailsByEmpCode(String empCode);

	Employee validateCredentials(String emp_code);

	boolean updateEmployeePasswordInDatabase(Employee employee);
}
