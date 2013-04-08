package com.moviesdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// get all username and password value
		java.util.Map<String, String[]> submission = request.getParameterMap();
		String loggedinemail = " ";
		String loggedinpwd = " ";
		String newemail = " ";
		String password2 = " ";
		String firstName = " ";
		String lastName = " ";
		String[] loggedinemail_received = submission.get("loggedinemail");
		String[] visitingemail_received = submission.get("visitingemail");
		String[] password_received = submission.get("pwd");
		String[] newemail_received = submission.get("newemail");
		String[] password2_received = submission.get("pwd2");
		String[] firstName_received = submission.get("firstName");
		String[] lastName_received = submission.get("lastName");
		if (loggedinemail_received != null)
			loggedinemail = loggedinemail_received[0];

		if (password_received != null)
			loggedinpwd = password_received[0];

		if (newemail_received != null)
			newemail = newemail_received[0];

		if (password2_received != null)
			password2 = password2_received[0];

		if (firstName_received != null)
			firstName = firstName_received[0];

		if (lastName_received != null)
			lastName = lastName_received[0];
		// Authentication the user email by checking the user name in the
		// database

		String dbUser = "cd2665"; // enter your username here
		String dbPassword = "movies"; // enter your password here

		try {
			boolean authorized = false;
			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);

			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();
			query = "select email from users";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {

				// System.out.println(r.getString(1));
				if (r.getString(1).equals(loggedinemail)) {
					String passwordquery = new String();
					Statement s2 = conn.createStatement();
					passwordquery = "select password from users where email='"
							+ loggedinemail + "'";
					ResultSet r2 = s2.executeQuery(passwordquery);
					while (r2.next()) {
						if (r2.getString(1).equals(loggedinpwd)) {
							authorized = true;
							break;
						}
					}
					r2.close();
					s2.close();
				}
			}
			r.close();
			s.close();

			// if all information required is here, registration permitted
			if ((!newemail.equals(" ")) || (!password2.equals(" "))
					|| (!firstName.equals(" ")) || (!lastName.equals(" "))) {
				String regquery = new String();
				Statement s3 = conn.createStatement();
				regquery = "insert into users values('" + newemail + "','"
						+ firstName + "','" + lastName + "','" + password2
						+ "')";
				s3.executeQuery(regquery);
				s3.close();
				out.println("registration successful");
				authorized = true;
				loggedinemail = newemail;
			}
			conn.close();
			System.out.println(password2);
			System.out.println(newemail);
			if (!authorized) {
				// if authorization fails, go back to index page
				String message = "Dear " + loggedinemail
						+ ", you've got a wrong password or not registered yet";
				request.setAttribute("loginError", message);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
				out.println("user name incorrect");

			}
			out.println("User: " + loggedinemail
					+ " has logged in successfully");

		} catch (Exception e) {
			System.out.println("error in connecting database");
			e.printStackTrace(out);
		}

		out.println("<p align=\"right\">Logged in: " + loggedinemail + "</p>");
		out.println("Go to Movies A-Z ");
		out.println("<form action='movies' method='get' enctype='text/plain'>"
				+ "<input type=\"submit\" name=\"loggedinemail\" value=\""
				+ loggedinemail + "\"></form>");

		out.println("Go to Cast & Crew A-Z ");
		out.println("<form action='castandcrew' method='get' enctype='text/plain'>"
				+ "<input type=\"submit\" name=\"loggedinemail\" value=\""
				+ loggedinemail + "\"></form>");

		// divider line
		out.println("</br><hr>");
		String fullName = getFullName(loggedinemail);
		out.println("<h2>" + fullName + "'s profile" + "</h2>");
		out.println("</br>");
		out.println("</br><hr>");
		out.println("<h2>" + "Movies watched by " + fullName + "</h2>");
		getMovies(loggedinemail, response);
		out.println("<h2>" + "Movies rated by " + fullName + "</h2>");
		getRating(loggedinemail, response);
		getFriendsList(loggedinemail, response, loggedinpwd);
		getRecommendation(loggedinemail, response, loggedinpwd);
		// out.println("<h1>AAAAAA BBBBBBB Profile</h1>");

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public String getFullName(String userName) {

		String fullName = new String();
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

			query = "select firstname, lastname from users where email='"
					+ userName + "'";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				fullName = r.getString(1) + "  " + r.getString(2);
			}
			r.close();
			s.close();
			conn.close();

		} catch (Exception e) {
		}
		return fullName;

	}

	public void getMovies(String userName, HttpServletResponse response)
			throws ServletException, IOException {

		String dbUser = "cd2665"; // enter your username here
		String dbPassword = "movies"; // enter your password here
		PrintWriter out = response.getWriter();

		try {

			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);

			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();

			query = "select movies.mid, title, watcheddate from movies, watched where watched.mid = movies.mid and email='"
					+ userName + "'";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				System.out.println(r.getString(1));
				//movieTitles.add(r.getString(1) + "  " + r.getString(2));
				//out.println("<br>");
				out.println("<tr>");
                out.println("<td>" + r.getString(2) + "</td>");
                out.println("watched on: " + r.getString(3));
                out.println("<form action='moviedetails' method='get' enctype='text/plain'>" + 
             		   	   "<input type='submit' name='mid' value=" +
             		       "'" + r.getString(1) + "'/> " +
             		   	   "<input type=\"hidden\" value=\"" + userName + "\" name=\"loggedinemail\">" +
             		       
             		       "</form>");
                out.println("</tr>"); 													

			}
			r.close();
			s.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
	
	public void getRating(String userName, HttpServletResponse response)
			throws ServletException, IOException {

		String dbUser = "cd2665"; // enter your username here
		String dbPassword = "movies"; // enter your password here
		PrintWriter out = response.getWriter();

		try {

			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);

			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();

			query = "select title, rating, movies.mid from movies, rated where movies.mid = rated.mid and email='"
					+ userName + "'";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				//movieTitles.add(r.getString(1) + "  " + r.getString(2));
				out.println("<br>");
				out.println("<tr>");
                out.println("<td>" + r.getString(1) + "  ****** the rating is:   " + r.getString(2) + "</td>");
                out.println("<td><form action='moviedetails' method='get' enctype='text/plain'>" + 
             		   	   "<input type='submit' name='mid' value=" +
             		       "'" + r.getString(3) + "'/> " +
             		   	   "<input type=\"hidden\" value=\"" + userName + "\" name=\"loggedinemail\">" +
             		       "</form></td>");
                out.println("</tr>"); 													

			}
			r.close();
			s.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
	
	public void getFriendsList(String userName, HttpServletResponse response, String pwd)
			throws ServletException, IOException {

		String dbUser = "cd2665"; // enter your username here
		String dbPassword = "movies"; // enter your password here
		PrintWriter out = response.getWriter();

		try {

			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);

			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();

			 query = "SELECT u.firstname, u.lastname, u.email " +
        			 "FROM users u " +
        			 "where u.email IN (" +
            			 "SELECT f.friendsBEmail " +
            			 "FROM friendswith f " +
            			 "WHERE f.friendsAEmail = '" + userName + "' " +
            			 "UNION " +
	            			 "SELECT f1.friendsAEmail " + 
	            			 "FROM friendswith f1 " +
	            			 "WHERE f1.friendsBEmail = '" + userName + "')";
        	 
        	 ResultSet r = s.executeQuery(query);
        	 
        	 out.println("<h3>My Friends List</h3>");
        	 out.println("<table border=\"1\">");
             out.println("<tr>" +
							"<th>First Name</th>" +
							"<th>Last Name</th>" +
							"<th>Link to Profile Page</th>" +
							"</tr>");
        	 while(r.next()) {
                 out.println("<tr>");
                 out.println("<td>" + r.getString(1) + "</td>");
                 out.println("<td>" + r.getString(2) + "</td>");
                 out.println("<td>" + r.getString(3) + "</td>");
                 out.println("<td><form action='FriendProfile' method='get' enctype='text/plain'>" + 
                		 "<input type=\"hidden\" value=\"" + userName + "\" name=\"loggedinemail\">" +
                		 "<input type=\"hidden\" value=\"" + pwd + "\" name=\"password\">" +
              		   	 "<input type='submit' name='visitingemail' value=" +
                		 "'" + r.getString(3) + "'/> </form></td>");
                 out.println("</tr>");   
             }
             out.println("</table>");
             
             
             // divider line
             out.println("</br><hr>");
			r.close();
			s.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
	
	
	public void getRecommendation(String userName, HttpServletResponse response, String pwd)
			throws ServletException, IOException {

		String dbUser = "cd2665"; // enter your username here
		String dbPassword = "movies"; // enter your password here
		PrintWriter out = response.getWriter();

		try {

			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);

			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();
			
			query = "select distinct m.title, u.email from users u, rated r, movies m where r.rating > 5.0 and r.email = u.email and r.mid = m.mid and u.email in" +
			         "(select f.friendsaemail from friendswith f where f.friendsbemail = '"+userName+
			         "' union select f1.friendsbemail from friendswith f1 where f1.friendsaemail = '" +userName+"' )";
        	 
        	 ResultSet r = s.executeQuery(query);
        	 
        	 out.println("<h3>Other high rating movies view by my friends(>5.0):</h3>");
        	 out.println("<table border=\"1\">");
             out.println("<tr>" +
							"<th>Movie Title</th>" +
							"<th>Link to Profile Page</th>" +
							"</tr>");
        	 while(r.next()) {
                 out.println("<tr>");
                 out.println("<td>" + r.getString(1) + "</td>");
                 out.println("<td><form action='FriendProfile' method='get' enctype='text/plain'>" + 
                		 "<input type=\"hidden\" value=\"" + userName + "\" name=\"loggedinemail\">" +
                		 "<input type=\"hidden\" value=\"" + pwd + "\" name=\"password\">" +
              		   	 "<input type='submit' name='visitingemail' value=" +
                		 "'" + r.getString(2) + "'/> </form></td>");
                 out.println("</tr>");   
             }
             out.println("</table>");
             
             
             // divider line
             out.println("</br><hr>");
			r.close();
			s.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}

	}
}
