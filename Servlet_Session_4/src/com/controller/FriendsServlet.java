package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.EditFacade;
import com.facade.FriendsFacade;
import com.model.UserPOJO;
import com.validation.Validation;

/**
 * Servlet implementation class FriendsServlet
 */
public class FriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String organization = request.getParameter("organization");
		
		
		PrintWriter out = response.getWriter();

		FriendsFacade friendsFacade = FriendsFacade.getInstance();
		ArrayList<UserPOJO> user = friendsFacade.giveUserFriendsFromDatabase(organization);
		
		if(user!=null){
			
			out.println("<html>");
			out.println("<body align='center'>");
			out.println("<table align=\"center\" width=50% >");
			out.println("<tr>");
			out.println("<th><h1>FirstName</h1></th>");
			out.println("<th><h1>LastName</h1></th>");
			out.println("<th><h1>UpdateLink</h1></th>");
			out.println("</tr>");
			
			
			
			for(UserPOJO obj: user){
				
				out.println("<tr><form action='ViewFriendsProfileShow.jsp'>");
				out.println("<input type='hidden' value="+ obj.getEmail() +" name='email'>");
				out.println("<td align=\"center\"><strong>"+ obj.getFirstName() +"</strong></td>");
				out.println("<td align=\"center\"><strong>"+ obj.getLastName()+"</strong></td>");
				out.println("<td align=\"center\"><input type=\"submit\" value=\"VIEW PROFILE\"></td>");
				out.println("</form></tr>");
			}
			

		}else{
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">User cannot Update the details!!..</h2>");
				out.println("</html>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
}
