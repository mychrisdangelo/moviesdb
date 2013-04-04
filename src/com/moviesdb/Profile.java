package com.moviesdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        java.util.Map<String, String[]> submission = request.getParameterMap();
        String[] loggedinemail_received = submission.get("loggedinemail");
        String[] visitingemail_received = submission.get("visitingemail");
        
        
        String loggedinemail = loggedinemail_received[0];
        out.println("<p align=\"right\">Logged in: " + loggedinemail + "</p>"); 
        out.println("Go to Movies A-Z ");
        out.println("<form action='movies' method='get' enctype='text/plain'>" +
        		"<input type=\"submit\" name=\"loggedinemail\" value=\"" + loggedinemail + "\"></form>");
        
        out.println("Go to Cast & Crew A-Z ");
        out.println("<form action='castandcrew' method='get' enctype='text/plain'>" +
        		"<input type=\"submit\" name=\"loggedinemail\" value=\"" + loggedinemail + "\"></form>");      
        
        // divider line
        out.println("</br><hr>");
        
        out.println("<h1>AAAAAA BBBBBBB Profile</h1>");
        
        if (visitingemail_received != null) {
        	
	        String visitingemail = visitingemail_received[0];
	        // divider line
	        out.println("</br><hr>");
	        out.println("<h1>XXXX YYYYY Profile</h1>");
	        out.println("VISITING EMAIL: " + visitingemail + "</br>");
	        out.println("The profile of the friend should show instead of the current user.");
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
