package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*
	@Override
	public boolean addEmployee(Employee employee) {
		String employeeCode = (employeeDAO.getLastEmployeeAdded()).getEmpCode();
		String[] employeeCodePartArray = employeeCode.split("/");
		int seriesNumber = Integer.parseInt(employeeCodePartArray[1]);
		seriesNumber = seriesNumber + 1;
		employeeCode = employeeCodePartArray[0] + "/" + seriesNumber;
		employee.setEmpCode(employeeCode);
		System.out.println(employee.getEmpCode());
		return employeeDAO.createEmployee(employee);
	}
*/
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean addEmployee(Employee employee){
		
		List<Employee> employees = employeeRepository.getLastEmployeeAdded();
		
		String employeeCode = employees.get(0).getEmpCode();
		String[] employeeCodePartArray = employeeCode.split("/");
		int seriesNumber = Integer.parseInt(employeeCodePartArray[1]);
		seriesNumber = seriesNumber + 1;
		employeeCode = employeeCodePartArray[0] + "/" + seriesNumber;
		employee.setEmpCode(employeeCode);
		//System.out.println(employee.getEmpCode());
		employeeRepository.save(employee);
		return true;
	}
	

	@Override
	public Employee getEmployeeById(String employeeCode) {
		return employeeRepository.findOne(employeeCode);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return false;
	}


	
}
