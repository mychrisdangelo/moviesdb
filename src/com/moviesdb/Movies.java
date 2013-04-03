package com.moviesdb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;

public class Movies extends HttpServlet {

        public void doGet (HttpServletRequest request,
                        HttpServletResponse response)
        throws ServletException, IOException {

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                int i = 0;
                
                //String dbUser = "NOONESNAMEISTHIS";
               // String dbUser = "scott"; // enter your username here
                //String dbPassword = "tiger"; // enter your password here
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

                        query = "select title from movies";

                        ResultSet r = s.executeQuery(query);
                        
                        out.println("Movies A-Z </br>");
                        while(r.next()) {
                           out.println(r.getString(1) + "<form action='moviedetails' method='get' enctype='text/plain'>" + 
                        		   "<input type='submit' name='button' value=" +
                        		   "'" + r.getString(1) + "'/> </br>");
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

        }  // end doGet method

}  // end DatabaseServlet class
