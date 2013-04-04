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
         
         java.util.Map<String, String[]> submission = request.getParameterMap();
         String[] mid_received = submission.get("mid");
         String[] loggedinemail_received = submission.get("loggedinemail");
         String mid = mid_received[0];
         String loggedinemail = loggedinemail_received[0]; // "chris.dangelo@gmail.com"; // TODO = request.getParamater("email");
      
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

                 // print logged in name
                 out.println("<p align=\"right\">Logged in: " + loggedinemail + "</p>");     
                 
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
                     out.println("<td><form action='castandcrewdetails' method='get' enctype='text/plain'>" + 
                  		   	   "<input type='submit' name='cid' value=" +
                  		       "'" + r.getString(6) + "'/> " + 
                  		       "<input type=\"hidden\" value=\"" + loggedinemail + "\" name=\"loggedinemail\">" +
                  		       "</form> </td>");
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
                  * Your Rating for this movie
                  */
                 query = "select r.rating from rated r where r.email = '" + loggedinemail + 
          			   	"' AND r.mid = '" + mid+ "'";
                 r = s.executeQuery(query);
                 out.println("<h3>Rate this movie:</h3>");
                 out.println("Currently rating by you: " + (r.next() ? r.getString(1) : "none") + "</br>");
                 out.println("" +
                 "<form action=\"ratedmovie\"> " +
                 "<select name=\"rating\"> " +
                   "<option value=\"1\">1</option> " +
                   "<option value=\"2\">2</option> " +
                   "<option value=\"3\">3</option> " +
                   "<option value=\"4\">4</option> " +
                   "<option value=\"5\">5</option> " +
                   "<option value=\"6\">6</option> " +
                   "<option value=\"7\">7</option> " +
                   "<option value=\"8\">8</option> " +
                   "<option value=\"9\">9</option> " +
                   "<option value=\"10\">10</option> " +
                 "</select> " +
                 "<input type=\"hidden\" value=\"" + mid + "\" name=\"mid\">" +
                 "<input type=\"hidden\" value=\"" + loggedinemail + "\" name=\"loggedinemail\">" +
                 "<input type=\"submit\" value=\"Submit\"> " +
                 "</form> ");
                 
                 /*
                  * Friends Ratings of this movie
                  */
            	 query = "SELECT u.firstname, u.lastname, u.email, r.rating, r.comments " +
            			 "FROM users u, rated r " +
            			 "WHERE r.mid = '" + mid + "' AND r.email = u.email AND r.email IN (" +
	            			 "SELECT f.friendsBEmail " +
	            			 "FROM friendswith f " +
	            			 "WHERE f.friendsAEmail = '" + loggedinemail + "' " +
	            			 "UNION " +
		            			 "SELECT f1.friendsAEmail " + 
		            			 "FROM friendswith f1 " +
		            			 "WHERE f1.friendsBEmail = '" + loggedinemail + "')";
            	 
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
                  		   	   "<input type='submit' name='visitingemail' value=" +
                  		       "'" + r.getString(3) + "'/> </form></td>");
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
