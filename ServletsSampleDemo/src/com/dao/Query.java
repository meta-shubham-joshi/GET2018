package com.dao;

/**
 * Class for Query of the application.
 */
public class Query {

	/**
	 * Method having query to add Employee.
	 * 
	 * @return query for adding employee.
	 */
	public String addEmployee() {
		return "INSERT INTO EMPLOYEE VALUES(?,?,?,?)";
	}

	/**
	 * Method having query to serach employee details.
	 * 
	 * @return query for searching employee information.
	 */
	public String searchEmployeeDetails() {
		return "SELECT Email,FirstName,LastName,Age FROM Employee WHERE FirstName=? AND LastName=?";
	}

	/**
	 * Method having query for showing all the employees in the database.
	 * 
	 * @return query for showing all employees.
	 */
	public String showAllEmployee() {
		return "SELECT Email,FirstName,LastName,Age FROM Employee";
	}
	
	public String updateEmployeeDetails(String email){
		return "SELECT * FROM Employee WHERE Email like \"%"+email+"%\"";
	}
	
	public String updateEmployee() {
		return "UPDATE Employee SET firstname=?,lastname=?,age=? where email=?";
	}

}
