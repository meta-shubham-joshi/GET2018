package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.LoginFacade;
import com.facade.RegisterFacade;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("khlsgsgsg");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		LoginFacade loginFacade = LoginFacade.getInstance();
		
		if(loginFacade.checkValidityFromDatabase(email, password)){
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			
			// Reason i dont know why it has been added.
			request.getRequestDispatcher("UserDetailsShow.jsp").forward(request, response);
			//response.sendRedirect("UserDetailsShow.jsp");
		}else{
			out.println("<html>");
			out.println("<h2 style=\"color:green;text-align:center;\">Invalid Credentials Provided !!..</h2>");
			out.println("</html>");
		}

	}

	
}
