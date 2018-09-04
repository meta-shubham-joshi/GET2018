package com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ApplicationFilter
 */
public class ApplicationFilter implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest HttpRequest = (HttpServletRequest)request;
		HttpSession session = HttpRequest.getSession();
		
		if(session.getAttribute("email")==null){
		
			session.setAttribute("email",HttpRequest.getParameter("email").toString());
			
			// No logged in user found so redirect to the login page.
			RequestDispatcher requestDispatcher = HttpRequest.getRequestDispatcher("UserDetailsShow.jsp");
			requestDispatcher.include(request,response);
		}
		else{
			//User is Logged in so just continue the request.
		
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
