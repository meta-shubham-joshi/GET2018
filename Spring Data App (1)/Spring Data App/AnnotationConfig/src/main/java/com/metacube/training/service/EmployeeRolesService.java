package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeRoles;

public interface EmployeeRolesService {

	boolean addEmployeeRole(Employee employee, String employeeRole);

//	List<EmployeeRoles> getAllEmployeesByRole(String employeeRole);

}
