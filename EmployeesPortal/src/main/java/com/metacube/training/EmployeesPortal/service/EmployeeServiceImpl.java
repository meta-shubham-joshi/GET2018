package com.metacube.training.EmployeesPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeesPortal.dao.EmployeeDAO;
import com.metacube.training.EmployeesPortal.dao.ProjectDAO;
import com.metacube.training.EmployeesPortal.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

}
