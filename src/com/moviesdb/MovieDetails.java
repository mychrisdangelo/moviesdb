package com.moviesdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
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

		
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         String mid = request.getParameter("mid");
      
         String dbUser = "cd2665"; // enter your username here
         String dbPassword = "movies"; // enter your password here
         
         String query =  new String();
         query = "select m.title, m.synopsis , m.runningTime, m.country, m.language, m.releaseDate " + 
        		 "from movies m " +
        		 "where m.mid='" + mid + "'";
         
         try {
                 OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
                 ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
                 ods.setUser(dbUser);
                 ods.setPassword(dbPassword);

                 Connection conn = ods.getConnection();
                 Statement s = conn.createStatement();
                 ResultSet r = s.executeQuery(query);
       
                 while(r.next()) {
                	 out.println("Title: " + r.getString(1) + "</br>");
                	 out.println("Running Time: " + r.getString(3) + "</br>");
                	 out.println("Synopsis: " + r.getString(2) + "</br>");
                	 out.println("Country: " + r.getString(4) + "</br>");
                	 out.println("Language: " + r.getString(5) + "</br>");
                	 out.println("Release Date: " + r.getDate(6) + "</br>");

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
