package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
/**
 * Servlet implementation class TestdbServlet
 */
@WebServlet("/TestdbServlet")
public class TestdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		

		String jdbcurl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSLL=false&serverTimezone=UTC";
		String user="springstudent";
		String pass="springstudent";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out=response.getWriter();
			out.println("connecting to database: " + jdbcurl);
			
			Class.forName(driver);
			
			Connection myConn =DriverManager.getConnection(jdbcurl,user,pass);
			
			out.println("s");
			myConn.close();
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}

		
		
	}

}
