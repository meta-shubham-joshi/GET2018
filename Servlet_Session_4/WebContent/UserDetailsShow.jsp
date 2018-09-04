<%@page import="java.sql.Date"%>
<%@page import="com.model.UserPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="css/style.css">

<title>User Details</title>

</head>

<header>
	<div class="title">
		<span class="image"> <a href="index.html"><img
				src="images/MetaCube-Logo.jpg" width=150px /></a>
		</span>
	</div>
</header>


<body>

<jsp:useBean id="getUserDetails" class = "com.facade.UserFacade"/>
<%
	String email = session.getAttribute("email").toString();
	UserPOJO user;
	String organisationName;
	if(email.equals(request.getAttribute("email"))){
   		user = getUserDetails.gettingUserDetailsFromDatabase(email);
		organisationName=user.getOrganization();
	}else{
		user = getUserDetails.gettingUserDetailsFromDatabase(request.getParameter("email"));
		organisationName = user.getOrganization();
	}
%>


<div align="right">
		<table>
			<tr>
				<td align="right"
					style="display: block; margin-top: 12px; margin-bottom: 12px; margin-right: 10px; width: 100%">
					<a href="FriendsServlet?organization=<%=organisationName%>"  id="sublink">FRIENDS</a>
					<a href="LogOutServ" id="sublink">LOGOUT</a>	
				</td>
			</tr>
		</table>
</div>

<div align="right">
		<h2>Upload Image</h2>
		<form action="UploadImageOfUser" name="uploadForm"  method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
			<h1>
			<th>HI USER</th>
			</h1>
			<td> <img src="images/Imagenew.png" height="100" width="80"/> </td>
			</tr>
			<tr>
			<td> <input type="hidden" name="email" value="<%= email %>"> </td>
			</tr>
			<tr>
				<td> <input type="file" name="myFile">
				<input type="submit" value="UPLOAD">
				</td>
			</tr>
		</table>
		</form>
</div>

<div><center>
		<h2>User Details</h2>
		<form action="EditServ">
			<table>
			
				<tr>
					<td>First Name: </td>
					<td> <% String firstName= user.getFirstName(); %>
					<a> <% out.println("<td><input type=\"text\" value="+ firstName +" name=\"firstname\" readonly></td>"); %> </a></td>
				</tr>
				
				<tr>
					<td>Last Name: </td>
					<td> <% String lastName = user.getLastName(); %> 
					<a> <% out.println("<td><input type=\"text\" value="+ lastName +" name=\"lastname\" readonly></td>"); %> </a></td>
				</tr>
				
				<tr>
					<td>Age: </td>
					<td> <% int age = user.getAge(); %> 
					<a> <% out.println("<td><input type=\"text\" value="+ age +" name=\"age\" readonly></td>"); %> </a></td>
				</tr>
				
				<tr>
					<td>Contact Number: </td>
					<td> <% String contactNumber = user.getContactNo(); %>
					<a> <% out.println("<td><input type=\"text\" value="+ contactNumber +" name=\"contactNumber\" readonly></td>"); %> </a></td>
				</tr>
				
				<tr>
					<td>DateOfBirth: </td>
					<td> <% Date date = user.getDate(); %> 
					<a> <%out.println("<td><input type=\"text\" value="+ date +" name=\"dateOfBirth\" readonly></td>"); %></a></td>
				</tr>
				
				<tr>
					<td>Email: </td>
					<td> <% String emails = user.getEmail(); %>
					<a> <% out.println("<td><input type=\"text\" value="+ emails +" name=\"email\" readonly></td>"); %> </td>
				</tr>
				
				<tr>
					<td>Company/Institution: </td>
					<td> <% String Company = user.getOrganization();  %>
					<a> <%  out.println("<td><input type=\"text\" value="+ Company +" name=\"organization\" readonly></td>");%> </a></td>
				</tr>
				
			</table>
			<input type="submit" value="Edit">
		</form>
	</center></div>
	


</body>

</html>