package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */

public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		System.out.println("Inside Logout Servlet");
		
		HttpSession existingSession = request.getSession(false);
		if (existingSession != null && existingSession.getAttribute("email") != null){
		   
		   existingSession.invalidate();
		   System.out.println("Session is destroyed!!..");
		}
		    
		PrintWriter out = response.getWriter();
			
		out.println("<html>");
		out.println("<h2 style=\"color:green;text-align:center;\">Session is successfully Invalidated!!..</h2>");
		out.println("</html>");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
		requestDispatcher.include(request,response);
		*/
		
		HttpSession session = request.getSession();

        //
        // Invalidate the session and removes any attribute related to it
        //
        session.invalidate();

        //
        // Get an HttpSession related to this request, if no session exist don't
        // create a new one. This is just a check to see after invalidation the
        // session will be null.
        //
        session = request.getSession(false);

        response.getWriter().println("Session : " + session);
	}



}
