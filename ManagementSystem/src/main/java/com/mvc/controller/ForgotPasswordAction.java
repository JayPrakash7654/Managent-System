package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import com.mvc.util.DBConnection;


public class ForgotPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ForgotPasswordAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		String securityquestions=request.getParameter("securityquestions");
		String answer=request.getParameter("answer");
		String newpass=request.getParameter("newpass");

		int check=0;
		try
		{
			Connection con=DBConnection.createConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from user where email='"+email+"' and mobileno='"+mobileno+"' and securityquestions='"+securityquestions+"' and answer='"+answer+"'");
			while(rs.next())
			{
				check=1;
				st.executeUpdate("update user set pass='"+newpass+"' where email='"+email+"'");
				response.sendRedirect("forgotPassword.jsp?msg=done");
			}
			if(check==0)
			{
				response.sendRedirect("forgotPassword.jsp?msg=invalid");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	}

