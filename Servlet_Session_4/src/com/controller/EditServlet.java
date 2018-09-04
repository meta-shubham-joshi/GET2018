package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.EditFacade;
import com.facade.RegisterFacade;
import com.model.UserPOJO;
import com.validation.Validation;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		int age = Integer.parseInt(request.getParameter("age"));
		String contactNo = request.getParameter("contactNumber");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = request.getParameter("dateOfBirth");
		Date date=null;
		try {
			date = new java.sql.Date(sdf.parse(parameter).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();
		
		out.println("<div><center>");
		out.println("<h2>User Details</h2>");
		out.println("<form action='EditServletFinalPath'>");
		out.println("<table>");
		
		out.println("<tr>");
		out.println("<td>First Name: </td>");
		out.println("<td><input type=\"text\" value="+ firstName +" name=\"firstname\"></td>"); 
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Last Name: </td>");
		out.println("<td><input type=\"text\" value="+ lastName +" name=\"lastname\"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Age: </td>");
		out.println("<td><input type=\"text\" value="+ age +" name=\"age\"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Contact Number: </td>");
		out.println("<td><input type=\"text\" value="+ contactNo +" name=\"contactNumber\"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>DateOfBirth: </td>");
		out.println("<td><input type=\"text\" value="+ date +" name=\"dateOfBirth\"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Email: </td>");
		out.println("<td><input type=\"text\" value="+ email +" name=\"Email\" readonly></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Organization: </td>");
		out.println("<td><input type=\"text\" value="+ request.getParameter("organization") +" name=\"organization\" readonly></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<input type='submit' value='SAVE'>");
		out.println("</form>");
		out.println("</center></div>");
		
		}

}

