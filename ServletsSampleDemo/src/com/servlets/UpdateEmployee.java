package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JDBCConnection;
import com.dao.Query;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = JDBCConnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");
		int result=0;
		PrintWriter out = response.getWriter();
		try{
			String email = request.getParameter("email");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int age = Integer.parseInt(request.getParameter("age"));
			Query query = new Query();
			String queryForUpdate = query.updateEmployee();
			PreparedStatement preparedStatement=connection.prepareStatement(queryForUpdate);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(4, email);
			preparedStatement.setInt(3, age);
			
			result=preparedStatement.executeUpdate();
			if(result>0) {
				out.println("<html>");
				 out.println("<h2 style=\"color:green;text-align:center;\">Information Updated !</h2>");
				 out.println("</html>");
				 
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("ShowAllEmployee");
				 requestDispatcher.include(request, response);
			} else {
				 out.println("<html>");
				 out.println("<h2 style=\"color:red;text-align:center;\">Information not updated !</h2>");
				 out.println("</html>");
				 
				 RequestDispatcher requestDispatcher=request.getRequestDispatcher("ShowAllEmployee");
				 requestDispatcher.include(request, response);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
			}
		}

}
