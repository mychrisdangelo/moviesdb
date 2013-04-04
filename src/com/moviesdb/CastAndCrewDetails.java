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
        
        
        String dbUser = "cd2665"; // enter your username here
        String dbPassword = "movies"; // enter your password here
        
        String query =  new String();
        query = "select c.firstname, c.lastname, c.gender, c.dob, c.trivia " + 
       		 "from castcrew c " +
       		 "where c.cid='" + cid + "'";
        
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
                 * Basic Cast/Crew Details
                 */
                while(r.next()) {
               	 out.println("<h1>" + r.getString(1) + " " + r.getString(2) + "</h1>");
               	 out.println("Gender: " + r.getString(3) + "</br>");
               	 out.println("Date of birth: " + r.getString(4) + "</br>");
               	 out.println("Trivia: " + r.getString(5) + "</br>");
                }
                
                /*
                 * Movies this person has been in
                 */
	           	 query = "select m.mid, m.title, m.releaseDate " +
	           	 		 "from movies m, workedin w " +
	           			 "where w.cid='" + cid + "' and w.mid = m.mid " +
	           	 		 "order by m.releaseDate";
	           	 
	           	 r = s.executeQuery(query);
	           	 
	           	 out.println("<h3>Movies worked on</h3>");
	           	 out.println("<table border=\"1\">");
	                out.println("<tr>" +
									"<th>Title</th>" +
									"<th>Release Date</th>" +
									"<th>Link to Movie Details</th>" +
									"</tr>");
	           	 while(r.next()) {
	                    out.println("<tr>");
	                    out.println("<td>" + r.getString(2) + "</td>");
	                    out.println("<td>" + r.getString(3) + "</td>");                    
	                    out.println("<td><form action='moviedetails' method='get' enctype='text/plain'>" + 
	                 		   	   "<input type='submit' name='mid' value=" +
	                 		       "'" + r.getString(1) + "'/> " + 
	                 		       "<input type=\"hidden\" value=\"" + loggedinemail + "\" name=\"loggedinemail\">" +
	                 		       "</form> </td>");
	                    out.println("</tr>");   
	            }
	            out.println("</table>");
	            
	            // divider line
                out.println("</br><hr>");
	            
	            /*
                 * Your Rating for this cast/crew member
                 */
                query = "select r.rating " +
                		"from castcrewrated r " + 
                		"where r.email = '" + loggedinemail + 
         			   	"' AND r.cid = '" + cid + "'";
                r = s.executeQuery(query);
                out.println("<h3>Rate this person:</h3>");
                out.println("Currently rating by you: " + (r.next() ? r.getString(1) : "none") + "</br>");
                out.println("" +
                "<form action=\"ratedcastcrew\"> " +
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
                "<input type=\"hidden\" value=\"" + cid + "\" name=\"cid\">" +
                "<input type=\"hidden\" value=\"" + loggedinemail + "\" name=\"loggedinemail\">" +
                "<input type=\"submit\" value=\"Submit\"> " +
                "</form> ");
                
                
                /*
                 * Friends Ratings of this movie
                 */
	           	 query = "SELECT u.firstname, u.lastname, u.email, r.rating " +
	           			 "FROM users u, castcrewrated r " +
	           			 "WHERE r.cid = '" + cid + "' AND r.email = u.email AND r.email IN (" +
		            			 "SELECT f.friendsBEmail " +
		            			 "FROM friendswith f " +
		            			 "WHERE f.friendsAEmail = '" + loggedinemail + "' " +
		            			 "UNION " +
			            			 "SELECT f1.friendsAEmail " + 
			            			 "FROM friendswith f1 " +
			            			 "WHERE f1.friendsBEmail = '" + loggedinemail + "')";
	           	 
	           	 r = s.executeQuery(query);
	           	 
	           	 out.println("<h3>Friends of mine who have rated this person:</h3>");
	           	 out.println("<table border=\"1\">");
	                out.println("<tr>" +
									"<th>First Name</th>" +
									"<th>Last Name</th>" +
									"<th>Rating of Person</th>" +
									"<th>Link to Profile Page</th>" +
									"</tr>");
	           	 while(r.next()) {
	                    out.println("<tr>");
	                    out.println("<td>" + r.getString(1) + "</td>");
	                    out.println("<td>" + r.getString(2) + "</td>");
	                    out.println("<td>" + r.getString(4) + "</td>");
	                    out.println("<td><form action='profile' method='get' enctype='text/plain'>" + 
	                   		 "<input type=\"hidden\" value=\"" + loggedinemail + "\" name=\"loggedinemail\">" +
	                 		   	 "<input type='submit' name='visitingemail' value=" +
	                   		 "'" + r.getString(3) + "'/> </form></td>");
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
