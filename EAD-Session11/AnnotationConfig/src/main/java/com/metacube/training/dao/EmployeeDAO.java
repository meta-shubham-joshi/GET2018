package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	boolean createEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee getEmployeeDetailsByEmpCode(String empCode);

	Employee validateCredentials(String emp_code);

	boolean updateEmployeePasswordInDatabase(Employee employee);

	Employee getEmployeeByEmail(String email);

	List<Employee> getEmployeeByName(String name);

	//Employee getEmployeeByID(int id);

	boolean delete(Employee employee);

	Employee getLastEmployeeAdded();
}
