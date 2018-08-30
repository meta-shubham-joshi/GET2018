package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeOperation;
import com.dao.EmployeePOJO;
import com.dao.JDBCConnection;

public class SearchEmployeeDetails extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = JDBCConnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");

			String firstName = req.getParameter("FirstName");
			String lastName = req.getParameter("LastName");
			
			PrintWriter out = res.getWriter();
			
			EmployeeOperation employeeoperation = new EmployeeOperation();
			ArrayList<EmployeePOJO> result = employeeoperation.searchEmployeeDetails(firstName, lastName);

			out.println("<html>");
			out.println("<body align=\"center\">");
			out.println("<table align=\"center\" width=50% >");

			if(result.size()>0){
				out.println("<tr>");
				out.println("<th><h1>Email</h1></th>");
				out.println("<th><h1>Age</h1></th>");
				out.println("</tr>");
				for(EmployeePOJO val : result) {
					out.println("<tr>");
					out.println("<td align=\"center\">"
								+ val.getEmail() + "</td>");
					out.println("<td align=\"center\">"
								+ val.getAge() + "</td>");
					out.println("</tr>");
					
				} 
			}
			else {
				out.println("<h2 style=\"color:green;text-align:center;\">No Employee Exist With The Given Name!</h2>");
			}

			out.println("<hr/><h2><a href=\"index.html\">HOME</a></h2>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
	}
}
