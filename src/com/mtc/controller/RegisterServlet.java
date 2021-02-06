package com.mtc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerprocess")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("***RegisterServlet : doGet()***");
		
		
		 String firstname = request.getParameter("firstname");
		 String lastname = request.getParameter("lastname");
		 String email = request.getParameter("email");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 
		 PrintWriter out = response.getWriter();
		 
		 out.println("<html><body>");
		 out.println("<h2> Thank you!You are registered successfully");
		 
		 out.println("<p>");
		 out.println("Firstname: "+firstname);
		 out.println("</p>");
		 
		 out.println("<p>");
		 out.println("Email: "+email);
		 out.println("</p>");
		 
		 out.println("</html></body>");
		
		
	}

}
