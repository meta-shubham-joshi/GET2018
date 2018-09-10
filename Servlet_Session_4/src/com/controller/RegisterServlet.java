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

import com.facade.RegisterFacade;
import com.model.UserPOJO;
import com.validation.Validation;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String contactNo = request.getParameter("contact");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = request.getParameter("date");
		Date date=null;
		try {
			date = new java.sql.Date(sdf.parse(parameter).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String organization = request.getParameter("select");
		String image_url = "/Servlet_Session_4/WebContent/images/profilepic.jpg";
		
		PrintWriter out = response.getWriter();

		UserPOJO userdetails = new UserPOJO(firstName, lastName, age, contactNo, date , email, password, confirmPassword, organization, image_url);
		
		Validation validate = new Validation();
		
		if(validate.nameValidation(firstName) 
				&& validate.nameValidation(lastName) 
				&& validate.validateContact(contactNo) 
				&& validate.mailValidation(email)
				&& validate.validatePassword(password, confirmPassword)){
			
			RegisterFacade registerfacade = RegisterFacade.getInstance();
			
			if(registerfacade.addToDatabase(userdetails)){
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">User Successfully Added !</h2>");
				out.println("</html>");

				RequestDispatcher requestdispatcher = request
						.getRequestDispatcher("Login.html");
				requestdispatcher.include(request, response);
			}else{
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">User cannot be added!!..</h2>");
				out.println("</html>");
			}
			
			
		}else{
			out.println("<html>");
			out.println("<h2 style=\"color:green;text-align:center;\">User Information provided is wrong!!..</h2>");
			out.println("</html>");
		}
		
	}


}
