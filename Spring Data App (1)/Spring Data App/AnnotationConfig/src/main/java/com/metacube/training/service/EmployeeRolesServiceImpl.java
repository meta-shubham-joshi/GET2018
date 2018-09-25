package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeRoles;
import com.metacube.training.repository.EmployeeRolesRepository;

@Service
public class EmployeeRolesServiceImpl implements EmployeeRolesService{

	@Autowired
	EmployeeRolesRepository employeeRolesRepository;
	
	@Override
	public boolean addEmployeeRole(Employee employee, String employeeRole) {
		EmployeeRoles employeeRoles = new EmployeeRoles();
		employeeRoles.setEmpCode(employee.getEmpCode());
		employeeRoles.setEmpRole(employeeRole);
		employeeRolesRepository.save(employeeRoles);
		return true;
	}

//	@Override
//	public List<EmployeeRoles> getAllEmployeesByRole(String employeeRole) {
//		return employeeRolesRepository.findAll
//	}

}
