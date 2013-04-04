package com.moviesdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class CastAndCrew
 */
@WebServlet("/CastAndCrew")
public class CastAndCrew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CastAndCrew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String loggedinemail = request.getParameter("loggedinemail");
	
        String dbUser = "cd2665"; // enter your username here
        String dbPassword = "movies"; // enter your password here

        try {
                OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
                ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
                ods.setUser(dbUser);
                ods.setPassword(dbPassword);
        
                Connection conn = ods.getConnection();

                String query = new String();
                Statement s = conn.createStatement();
                
                query = "select cid, firstname, lastname " +
                		"from castcrew order by lastname asc";
                ResultSet r = s.executeQuery(query);
    
                // print logged in name
		        out.println("<p align=\"right\">Logged in: " + loggedinemail + "</p>");     
		        
		        out.println("<h1>Cast and Crew A-Z </h1>");
                out.println("<table border=\"1\">");
                out.println("<tr>" +
							"<th>First Name</th>" +
							"<th>Last Name</th>" +
							"<th>Link to Cast/Crew Details</th>" +
							"</tr>");
                while(r.next()) {
                    out.println("<tr>");
                    out.println("<td>" + r.getString(2) + "</td>");
                    out.println("<td>" + r.getString(3) + "</td>");
                    out.println("<td><form action='castandcrewdetails' method='get' enctype='text/plain'>" + 
                 		   	   "<input type='submit' name='cid' value=" +
                 		       "'" + r.getString(1) + "'/> " +
                 		   	   "<input type=\"hidden\" value=\"" + loggedinemail + "\" name=\"loggedinemail\">" +
                 		       "</form></td>");
                    out.println("</tr>");                           
                }
                out.println("</table>");
		        r.close();
                s.close();
                conn.close();

        }
        catch (Exception e) {
                out.println("The database could not be accessed.<br>");
                out.println("More information is available as follows:<br>");
                e.printStackTrace(out);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
