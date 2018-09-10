package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.EditFacade;
import com.validation.Validation;

/**
 * Servlet implementation class EditServletFinal
 */
@WebServlet("/EditServletFinal")
public class EditServletFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		

		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("Email");
		
		
		
		Validation validate = new Validation();
		
		if(validate.nameValidation(firstName) 
				&& validate.nameValidation(lastName) 
				&& validate.validateContact(contactNo)){
			
			EditFacade editFacade = EditFacade.getInstance();
			
			if(editFacade.updateUserDetailsInDatabase(firstName,lastName,age,contactNo, date, email)){
				
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">User Successfully Updated The Details!!..</h2>");
				out.println("</html>");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserDetailsShow.jsp");
				requestDispatcher.include(request,response);

			}else{
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">User cannot Update the details!!..</h2>");
				out.println("</html>");
			}
			
			
		}else{
			out.println("<html>");
			out.println("<h2 style=\"color:green;text-align:center;\">User Information provided is wrong!!..</h2>");
			out.println("</html>");
		}
		
	}

}
