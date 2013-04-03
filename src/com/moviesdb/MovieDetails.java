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
 * Servlet implementation class Test1
 */
public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         out.println("test!!!!");
         String keyName = request.getParameter("button");
         out.println(keyName);
         
         response.setContentType("text/html");

         String dbUser = "cd2665"; // enter your username here
         String dbPassword = "movies"; // enter your password here
         
         String query = "SELECT m.title " + 
        		 "FROM movies m, castcrew c, workedin w " +
        		 "WHERE m.mid = w.mid AND w.cid = c.cid AND c.firstname = 'Harrison' AND c.lastname = 'Ford';";

         try {
                 OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
                 ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
                 ods.setUser(dbUser);
                 ods.setPassword(dbPassword);

                 Connection conn = ods.getConnection();
                 Statement s = conn.createStatement();
                 ResultSet r = s.executeQuery(query);
                 
                 out.println("Movie Name: " + keyName + "</br>");
                 out.println("Test: MOVIES HARRISON FORD ARE IN</br>");
               
                 while(r.next()) {
                	 String movieTitle = r.getString(1);
                	 out.println("movieTitle: " + movieTitle);
                 }
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
		// TODO Auto-generated method stub
	}

}
