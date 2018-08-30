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

import com.dao.EmployeePOJO;
import com.dao.JDBCConnection;

public class ShowAllEmployee extends HttpServlet {

	/**
	 * Method for getting the request and processing it and fetching the values
	 * from the database and storing it to the table.
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param res
	 *            HttpServletResponse
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = JDBCConnection.getDatabaseConnection(
				"EmployeeDetails", "root", "papaji@028");
		try {
			String query = "SELECT Email,FirstName,LastName,Age FROM Employee";

			PrintWriter out = res.getWriter();
			PreparedStatement preparedstatement = connection
					.prepareStatement(query);
			
			out.println("<html>");
			out.println("<body align='center'>");
			out.println("<table align=\"center\" width=50% >");
			out.println("<tr>");
			out.println("<th><h1>Email</h1></th>");
			out.println("<th><h1>FirstName</h1></th>");
			out.println("<th><h1>LastName</h1></th>");
			out.println("<th><h1>Age</h1></th>");
			out.println("<th><h1>UpdateLink</h1></th>");
			out.println("</tr>");
			
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next()){
				EmployeePOJO employee = new EmployeePOJO(resultset.getString("FirstName"),resultset.getString("LastName"),resultset.getString("Email"),resultset.getInt("Age"));
			
					out.println("<tr><form action='UpdateDetails'>");
					out.println("<td align=\"center\"><strong>"+employee.getEmail()+"</strong></td>");
					out.println("<input type='hidden' value="+employee.getEmail()+" name='email'>");
					out.println("<td align=\"center\"><strong>"+employee.getFirstName()+"</strong></td>");
					out.println("<td align=\"center\"><strong>"+employee.getLastName()+"</strong></td>");
					out.println("<td align=\"center\"><strong>"+employee.getLastName()+"</strong></td>");
					out.println("<td align=\"center\"><input type=\"submit\" value=\"Update Details\"></td>");
					out.println("</form></tr>");
			}

			out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
