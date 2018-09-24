package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Query("FROM Employee ORDER BY empCode DESC ")
	List<Employee> getLastEmployeeAdded();

}
