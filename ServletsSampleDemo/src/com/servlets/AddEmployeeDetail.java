package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeOperation;
import com.dao.EmployeePOJO;
import com.dao.JDBCConnection;

/**
 * Class for storing the employee details in the database.
 */
public class AddEmployeeDetail extends HttpServlet {

	/**
	 * Method for getting the request and processing it and storing the values
	 * into the database.
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param res
	 *            HttpServletResponse
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		JDBCConnection jdbcconnection = new JDBCConnection();
		Connection connection = jdbcconnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");

		String firstName = req.getParameter("FirstName");
		String lastName = req.getParameter("LastName");
		String email = req.getParameter("Email");
		int age = Integer.parseInt(req.getParameter("Age"));

		EmployeePOJO employee = new EmployeePOJO(firstName, lastName, email,
				age);
		EmployeeOperation employeeoperation = new EmployeeOperation();

		PrintWriter out = res.getWriter();

		int result = employeeoperation.addEmployee(employee);

		if (result > 0) {
			out.println("<html>");
			out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
			out.println("</html>");

			RequestDispatcher requestdispatcher = req
					.getRequestDispatcher("addemployeedetail.html");
			requestdispatcher.include(req, res);
		} else {
			System.out.println("!!Error!!");
		}

	}

}
