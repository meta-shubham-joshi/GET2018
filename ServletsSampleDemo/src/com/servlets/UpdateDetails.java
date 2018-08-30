package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JDBCConnection;
import com.dao.Query;

public class UpdateDetails extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = JDBCConnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");
		
		try{
			String email = req.getParameter("email");
			Query query = new Query();
			String queryForUpdate = query.updateEmployeeDetails(email); 
			
			System.out.println(queryForUpdate);
			
			
			PrintWriter out = res.getWriter();
			PreparedStatement preparedstatement;
			preparedstatement = connection
						.prepareStatement(queryForUpdate);
			ResultSet resultset = preparedstatement.executeQuery();
			resultset.next();
			
			out.println("<html>");
			out.println("<body align='center'>");
			out.println("<h1 style='text-align:center;'>UPDATE EMPLOYEE DETAILS</h1>");
			out.println("<form action='UpdateEmployeeDetails' id='updateemployeeform'>");
			out.println("<table align=\"center\" width=50% >");
			
			out.println("<tr>");
			out.println("<td>FirstName</td>");
			out.println("<td><input type=\"text\" value="+resultset.getString("FirstName")+" name=\"firstname\"></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>LastName</td>");
			out.println("<td><input type=\"text\" value="+resultset.getString("LastName")+" name=\"lastname\"></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td><input type=\"text\" value="+resultset.getString("Email")+" name=\"email\" readonly></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Age</td>");
			out.println("<td><input type=\"text\" value="+resultset.getString("age")+" name=\"age\"></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><input type='submit' value='UPDATE'/></td>");
			out.println("</tr>");
			out.println("/table");
			out.println("/form");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
