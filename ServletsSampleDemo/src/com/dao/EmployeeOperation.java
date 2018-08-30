package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for performing the employee information.
 */
public class EmployeeOperation {

	/**
	 * Method to add employee to the database.
	 * 
	 * @param employee
	 *            - EmployeePOJO object having details of the employee.
	 * @return
	 */
	public int addEmployee(EmployeePOJO employee) {

		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");

		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String Email = employee.getEmail();
		int age = employee.getAge();
		int result = 0;

		try {
			Query query = new Query();

			String queryForAddingEmployee = query.addEmployee();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForAddingEmployee);

			preparedstatement.setString(1, Email);
			preparedstatement.setString(2, firstName);
			preparedstatement.setString(3, lastName);
			preparedstatement.setInt(4, age);

			result = preparedstatement.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;

	}

	/**
	 * Method to show all the employees by fetching result from the database.
	 * 
	 * @return the list of employees.
	 */
	public List<EmployeePOJO> showAllEmployee() {

		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");
		List<EmployeePOJO> list = new ArrayList<EmployeePOJO>();

		try {
			Query query = new Query();

			String queryForShowingEmployee = query.showAllEmployee();

			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForShowingEmployee);

			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				do {
					EmployeePOJO employee = new EmployeePOJO(
							resultset.getString("Email"),
							resultset.getString("FirstName"),
							resultset.getString("LastName"),
							resultset.getInt("Age"));
					list.add(employee);

				} while (resultset.next());
			} else {
				System.out.println("No Employee exist in the database!!..");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			;
		}
		return list;
	}

	/**
	 * Method for searching employee details.
	 * 
	 * @param firstName
	 *            firstname of the user.
	 * @param lastName
	 *            lastname of the user.
	 * @return
	 */
	public ArrayList<EmployeePOJO> searchEmployeeDetails(String firstName,
			String lastName) {

		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");

		ArrayList<EmployeePOJO> list = new ArrayList<EmployeePOJO>();

		try {

			Query query = new Query();

			String queryForSearchingEmployee = query.searchEmployeeDetails();
			
			PreparedStatement preparedstatement = connection
					.prepareStatement(queryForSearchingEmployee);
			preparedstatement.setString(1, firstName);
			preparedstatement.setString(2, lastName);

			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				do {
					EmployeePOJO employee = new EmployeePOJO(
							resultset.getString("FirstName"),
							resultset.getString("LastName"),
							resultset.getString("Email"),
							resultset.getInt("Age"));
					list.add(employee);
				} while (resultset.next());
			} else {
				System.out.println("Employee Information does not exist!!..");
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			;
		}
		return list;

	}

}