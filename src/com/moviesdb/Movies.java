package com.moviesdb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import oracle.jdbc.pool.*;

public class Movies extends HttpServlet {

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doGet (HttpServletRequest request,
                        HttpServletResponse response)
        throws ServletException, IOException {

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
                        
                        query = "select mid, title from movies order by title asc";
                        ResultSet r = s.executeQuery(query);
                        
                        // print logged in name
                        out.println("<p align=\"right\">Logged in: " + loggedinemail + "</p>");     
                        
                        out.println("<h1>Movies A-Z </h1>");
                        out.println("<table border=\"1\">");
                        out.println("<tr>" +
									"<th>Movie Title</th>" +
									"<th>Link to Movie Details</th>" +
									"</tr>");
                        while(r.next()) {
                           out.println("<tr>");
                           out.println("<td>" + r.getString(2) + "</td>");
                           out.println("<td><form action='moviedetails' method='get' enctype='text/plain'>" + 
                        		   	   "<input type='submit' name='mid' value=" +
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

        }  // end doGet method

}  // end DatabaseServlet class
