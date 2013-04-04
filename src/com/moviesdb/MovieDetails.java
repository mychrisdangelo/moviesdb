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
         String email = "chris.dangelo@gmail.com"; // TODO = request.getParamater("email");
      
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

                 /*
                  * Basic Movie Details
                  */
                 while(r.next()) {
                	 out.println("<h1>" + r.getString(1) + "</h1>");
                	 out.println("Running Time: " + r.getString(3) + "</br>");
                	 out.println("Synopsis: " + r.getString(2) + "</br>");
                	 out.println("Country: " + r.getString(4) + "</br>");
                	 out.println("Language: " + r.getString(5) + "</br>");
                	 out.println("Release Date: " + r.getDate(6) + "</br>");	

                 }
                 
                 /*
                  * People that worked on the movie
                  */
            	 query = "select c.firstname, c.lastname, w.characterName, w.jobCategory, w.jobTitle, c.cid " +
            	 		 "from workedin w, castcrew c " +
            			 "where w.mid='" + mid + "' and w.cid = c.cid " +
            	 		 "order by w.billingNum";
            	 
            	 r = s.executeQuery(query);
            	 
            	 out.println("<h3>People that worked on this movie</h3>");
            	 out.println("<table border=\"1\">");
                 out.println("<tr>" +
								"<th>First Name</th>" +
								"<th>Last Name</th>" +
								"<th>Character Name</th>" +
								"<th>Job Category</th>" +
								"<th>Job Title</th>" +
								"<th>Link to Cast/Crew Page</th>" +
								"</tr>");
            	 while(r.next()) {
                     out.println("<tr>");
                     out.println("<td>" + r.getString(1) + "</td>");
                     out.println("<td>" + r.getString(2) + "</td>");
                     out.println("<td>" + r.getString(3) + "</td>");
                     out.println("<td>" + r.getString(4) + "</td>");
                     out.println("<td>" + r.getString(5) + "</td>");                     
                     out.println("<td><form action='castandcrew' method='get' enctype='text/plain'>" + 
                  		   	   "<input type='submit' name='cid' value=" +
                  		       "'" + r.getString(6) + "'/> </td>");
                     out.println("</tr>");   
                 }
                 out.println("</table>");
                 
                 /*
                  * Quotes
                  */
            	 query = "SELECT q.characterName, q.quote " +
            			 "FROM quotes q, movies m " +
            			 "Where m.mid =q.mid and m.mid = '" + mid +"'";

            	 
            	 r = s.executeQuery(query);
            	 
            	 out.println("<h3>Quotes from the movie</h3>");
            	 while(r.next()) {
                	 out.println(r.getString(1) + ": " + r.getString(2) + "</br>");
                 }
                 out.println("</table>");
                 
                 // divider line
                 out.println("</br><hr>");
                 
                 /*
                  * Friends Ratings of this movie
                  */
            	 query = "SELECT u.firstname, u.lastname, u.email, r.rating, r.comments " +
            			 "FROM users u, rated r " +
            			 "WHERE r.mid = '" + mid + "' AND r.email = u.email AND r.email IN (" +
	            			 "SELECT f.friendsBEmail " +
	            			 "FROM friendswith f " +
	            			 "WHERE f.friendsAEmail = '" + email + "' " +
	            			 "UNION " +
		            			 "SELECT f1.friendsAEmail " + 
		            			 "FROM friendswith f1 " +
		            			 "WHERE f1.friendsBEmail = '" + email + "')";
            	 
            	 r = s.executeQuery(query);
            	 
            	 out.println("<h3>Friends of mine who have rated this movie:</h3>");
            	 out.println("<table border=\"1\">");
                 out.println("<tr>" +
								"<th>First Name</th>" +
								"<th>Last Name</th>" +
								"<th>Rating of Movie</th>" +
								"<th>Comments</th>" +
								"<th>Link to Profile Page</th>" +
								"</tr>");
            	 while(r.next()) {
                     out.println("<tr>");
                     out.println("<td>" + r.getString(1) + "</td>");
                     out.println("<td>" + r.getString(2) + "</td>");
                     out.println("<td>" + r.getString(4) + "</td>");
                     out.println("<td>" + r.getString(5) + "</td>");
                     out.println("<td><form action='profile' method='get' enctype='text/plain'>" + 
                  		   	   "<input type='submit' name='email' value=" +
                  		       "'" + r.getString(3) + "'/> </td>");
                     out.println("</tr>");   
                 }
                 out.println("</table>");
                 
                 
                 // divider line
                 out.println("</br><hr>");
                 
                 /*
                  * Where is this movie playing?
                  */
            	 query = "SELECT t.theaterName, t.address, t.city, t.state, t.zip, p.perfDateTime " + 
            			 "FROM theaters t, movies m, playingat p " +
            			 "WHERE t.tid = p.tid AND m.mid = '" + mid + "' AND m.mid = p.mid";
            	 
            	 r = s.executeQuery(query);
            	 
            	 out.println("<h3>Where is the movie playing?</h3>");
            	 while(r.next()) {
                	 out.println("Theater Name: " + r.getString(1) + "</br>");
                	 out.println("Theater Address: " + r.getString(2) + ", " + r.getString(3) + ", " + r.getString(4) + " " + r.getString(5) + "</br>");
                	 out.println("Date/Time: " + r.getTimestamp(6) + "</br></br>");
                 }
                 out.println("</table>");
                 
                 /*
                  * Where can you rent it?
                  */
            	 query = "SELECT rs.serviceName, rs.sURL, rs.description, r.availFrom, r.availTo, r.price " + 
						 "FROM rentavailablefrom r, movies m, rentalservice rs " +
						 "WHERE rs.rid = r.rid AND m.mid = r.mid AND m.mid = '" + mid + "'";
            	 
            	 r = s.executeQuery(query);
            	 out.println("<h3>Where can you rent this movie?</h3>");
            	 while(r.next()) {
                	 out.println("Service: <a href=\"" + r.getString(2) + "\">" + r.getString(1) + "</a></br>");
                	 out.println("Description of Service: " + r.getString(3) + "</br>");
                	 out.println("Available: " + r.getTimestamp(4) + " to " + r.getTimestamp(5) + "</br>");
                	 out.println("Price: $" + r.getString(6) + "</br>");
                 }
                 out.println("</table>");
            	 
            	 
                 /*
                  * close connections
                  */
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
