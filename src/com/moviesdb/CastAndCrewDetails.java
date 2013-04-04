package com.moviesdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CastAndCrew
 */
@WebServlet("/CastAndCrewDetails")
public class CastAndCrewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CastAndCrewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // parse URL
        java.util.Map<String, String[]> submission = request.getParameterMap();
        String[] loggedinemail_received = submission.get("loggedinemail");
        String[] cid_received = submission.get("cid");  
        String cid = cid_received[0];
        String loggedinemail = loggedinemail_received[0];
        
        // print logged in name
        out.println("<p align=\"right\">Logged in: " + loggedinemail + "</p>");     
        out.println("cid from movie/details: " + cid + "</br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
