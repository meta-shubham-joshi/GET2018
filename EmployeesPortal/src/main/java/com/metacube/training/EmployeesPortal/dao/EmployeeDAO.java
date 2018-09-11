package com.metacube.training.EmployeesPortal.dao;

import java.util.List;

import com.metacube.training.EmployeesPortal.model.Employee;
import com.metacube.training.EmployeesPortal.model.Project;

public interface EmployeeDAO {

	boolean createEmployee(Employee employee);
	
	List<Employee> getEmployees();
	
	Employee getEmployeeDetailsByEmpCode(String empCode);
	
	Employee validateCredentials(String emp_code);
}
