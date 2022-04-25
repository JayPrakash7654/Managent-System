package com.mvc.controller;

import java.io.*;  
import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.util.DBConnection;


public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserDetail() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		
		try{
			PrintWriter out = response.getWriter();  
		       response.setContentType("text/html");  
		       out.println("<html><body>");
		       
		       String email=request.getParameter("email");
				String pass=request.getParameter("pass");

				int count=0;
			
			    Connection con = DBConnection.createConnection();  
			    Statement st=con.createStatement();
			    ResultSet rs=st.executeQuery("select * from user where email='"+email+"' and pass='"+pass+"'");
			    
			    while(rs.next())
			    {
			        count++;
			    }

			    if(count>0)
			    {
			         out.println("welcome "+ email);
			         Statement s=con.createStatement();
			         ResultSet rst=s.executeQuery("select * from user  where email='"+email+"' and pass='"+pass+"'");
			           
			         
			         while(rst.next())
			         {
			              out.println(rst.getString("firstname"));
			              out.println("<h3>Your Account Information</h3>");
			            
			              out.println("<table border='1' width='100%'");
			              out.println("<tr><th>UserId</th><th>FirstName</th><th>LastName</th><th>UserName</th><th>Email</th><th>Password</th"
			              		+ "><th>MobileNumber</th><th>Gender</th><th>SecurityQuestions</th><th>Answer</th><th align='center'>Photo</th><th>Date of birth</th><th>Edit</th><tr>"); 
			            
			               String id = rst.getString("id");  
			               String fn = rst.getString("firstname");  
			               String ln = rst.getString("lastname");   
			               String un = rst.getString("username");
			               String em = rst.getString("email");
			               String ps = rst.getString("pass");
			               String mn = rst.getString("mobileno");
			               String gn = rst.getString("gender");
			               String sq = rst.getString("securityquestions");
			               String an = rst.getString("answer"); 
			               String db = rst.getString("dob");
			               
			               out.println("<tr><td>" + id + "</td><td>" + fn + "</td><td>" + ln + "</td><td>" + un + "</td><td>" + em + "</td><td>" + ps + "</td>"
			               		+ "<td>" + mn + "</td><td>" + gn + "</td><td>" + sq + "</td><td>" + an + "</td>"
			               		+ " <td style='width:150px; height:125px;'><img src='" + "RetriveImage?" + id + "' style='width:150px; height:125px;'/></td><td>" + db + "</td><td><a href='EditUser?id="+id+"'>edit</a></td></tr>");
			               out.println("</table>");  
			               out.println("</html></body>");  
			               con.close();
			          }
			          }
			    
			          else
			          {
			        	  out.println("error");
			          }
			}

			catch(Exception e){
			    System.out.println(e);
			}
	}

}
