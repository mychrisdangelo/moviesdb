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
 * Servlet implementation class FriendProfile
 */
@WebServlet("/FriendProfile")
public class FriendProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// get all username and password value
		java.util.Map<String, String[]> submission = request.getParameterMap();
		String loggedinemail = " ";
		String visitingemail = " ";
		String loggedinpwd = " ";
		String[] loggedinemail_received = submission.get("loggedinemail");
		String[] visitingemail_received = submission.get("visitingemail");
		String[] loggedinpwd_received = submission.get("password");
		if (loggedinemail_received != null)
			loggedinemail = loggedinemail_received[0];
		if (visitingemail_received != null)
			visitingemail = visitingemail_received[0];
		if (loggedinpwd_received != null)
			loggedinpwd = loggedinpwd_received[0];
		/*out.print(loggedinemail);
		out.print(visitingemail);
		out.print(loggedinpwd);*/
		out.print("<form name='input' action='profile' method='get'><input type='hidden' name='loggedinemail' value='");
		out.print(loggedinemail);
		out.print("'><input type='hidden' name='pwd' value='");
		out.print(loggedinpwd);
		out.print("'><input type='submit' value='back to my profile'></form>");
		
		out.println("</br><hr>");
		String fullName = getFullName(visitingemail);
		out.println("<h2>" + fullName + "'s profile" + "</h2>");
		out.println("</br>");
		out.println("</br><hr>");
		out.println("<h2>" + "Movies watched by " + fullName + "</h2>");
		getMovies(visitingemail, response);
		out.println("<h2>" + "Movies rated by " + fullName + "</h2>");
		getRating(visitingemail, response);
		/*<form name='input' action='profile' method='get'>
		<input type='hidden' name='loggedinemail' value='loggedinemail'>
		<input type='hidden' name='pwd' value='loggedinpwd'>
		<input type='submit' value='back to my profile'>
		</form>*/
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
