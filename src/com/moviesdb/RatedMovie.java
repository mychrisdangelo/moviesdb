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
 * Servlet implementation class Profile
 */
@WebServlet("/RatedMovie")
public class RatedMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatedMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
      
        String dbUser = "cd2665"; // enter your username here
        String dbPassword = "movies"; // enter your password here
        
        java.util.Map<String, String[]> submission = request.getParameterMap();
        String[] rating = submission.get("rating");
        String[] mid = submission.get("mid");
        String[] email = submission.get("email");

        
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111g.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            String query = "select r.rating from rated r where r.email = '" + email[0] + "' AND r.mid = '" + mid[0] + "'";
            
            Connection conn = ods.getConnection();
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery(query);
            
            /*
             * Update rating if rating already exits
             */
            
            while(r.next()) {
            	r.updateFloat(1, Float.valueOf(rating[0]));
            	r.updateRow();
            }
            
            /*
             * If rating didn't exist insert it
             */
            
            query = "select count(*) from rated r where r.email = '" + email[0] + 
     			   	"' AND r.mid = '" + mid[0]+ "'";
            
            /*
             * Notify User
             */
            
	        out.println("Email: " + email[0] + "'s rating of: " + rating[0] + 
        		    " has been updated for the movie id: " + mid[0] + "</br>");

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
