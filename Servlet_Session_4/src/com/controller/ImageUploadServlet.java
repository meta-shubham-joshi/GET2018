package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.ImageFacade;
import com.facade.LoginFacade;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ImageUploadServlet
 */

public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("AA gaya");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session1 = request.getSession();
		
		String emailUser = (String) session1.getAttribute("email");

		MultipartRequest multipartRequest = new MultipartRequest(request, "C:\\Users\\User28\\workspace\\Servlet_Session_4\\WebContent\\images");
		
		Enumeration files = multipartRequest.getFileNames();
		String fileName = null;
		
		while (files.hasMoreElements()) {
		String name = (String) files.nextElement();
		fileName = multipartRequest.getFilesystemName(name);
		}
		
		ImageFacade imageFacade = ImageFacade.getInstance();
		
		if(imageFacade.addImageURLToDatabase(emailUser, fileName)){
			System.out.println("In if casekkgjkgkj");
			//RequestDispatcher requestdispatch = request.getRequestDispatcher("UserDetailsShow.jsp");
			//requestdispatch.include(request, response);
			request.getRequestDispatcher("UserDetailsShow.jsp").forward(request, response);

		}else{
			out.println("Image is not uploaded");
		}

		
	}

}
