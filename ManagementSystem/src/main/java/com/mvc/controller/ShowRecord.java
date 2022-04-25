package com.mvc.controller;

import java.io.IOException;
import java.io.*;  
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mvc.util.DBConnection;

public class ShowRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {  
       PrintWriter out = res.getWriter();  
       res.setContentType("text/html");  
       out.println("<html><head> <style> table {border-collapse: collapse;width: 100%;} th, td {padding: 8px;text-align: left; border-bottom: 1px solid #DDD;} tr:hover {background-color: rgb(143, 232, 226);}</style></head><body>");  
       try 
       {  
    	   Connection con=DBConnection.createConnection();  
            
           Statement stmt = con.createStatement();  
           ResultSet rs = stmt.executeQuery("select * from user, address1 where "	+ " user.id = address1.userid");  
           out.println("<title>DisplayData</title>");
           out.println("<a href='register.jsp'>Add New User</a>");
           out.println("<h1>User List</h1>");
           
           out.println("<table border='1' width='100%'");  
           out.println("<tr><th>UserId</th><th>FirstName</th><th>LastName</th><th>UserName</th><th>Email</th><th>Password</th><th>MobileNumber</th>"
           		+ "<th>Gender</th><th>SecurityQuestions</th><th>Answer</th><th align='center'>Photo</th><th>Date of birth</th><th>Address line1</th>"
           		+ "<th>Address line2</th><th>City</th><th>Pincode</th><th>State</th> <th>Edit</th><th>Delete</th><tr>");  
           while (rs.next()) 
           {  
               String id = rs.getString("id");  
               String fn = rs.getString("firstname");  
               String ln = rs.getString("lastname");   
               String un = rs.getString("username");
               String em = rs.getString("email");
               String ps = rs.getString("pass");
               String mn = rs.getString("mobileno");
               String gn = rs.getString("gender");
               String sq = rs.getString("securityquestions");
               String an = rs.getString("answer"); 
               String db = rs.getString("dob");
               String ad1 = rs.getString("addressline1");
               String ad2 = rs.getString("addressline2");
               String cty = rs.getString("city");
               String pin = rs.getString("pincode");
               String st = rs.getString("state");
                
               out.println("<tr><td>" + id + "</td><td>" + fn + "</td><td>" + ln + "</td><td>" + un + "</td><td>" + em + "</td><td>" + ps + "</td>"
               		+ "<td>" + mn + "</td><td>" + gn + "</td><td>" + sq + "</td><td>" + an + "</td> <td style='width:150px; height:125px;'><img src='" + "RetriveImage?" + id + "' style='width:150px; height:125px;'/></td>"
               				+ "<td>" + db + "</td><td>" + ad1 + "</td><td>" + ad2 + "</td><td>" + cty + "</td><td>" + pin + "</td><td>" + st + "</td><td><a href='EditUser?id="+id+"'>edit</a></td>"
               						+ "<td><a href='UserController?action=delete&userId=" + id +"'>delete</a></td></tr>");   
               
               }  
               
           out.println("</table>");  
           out.println("</html></body>");  
           con.close();  
          }  
           catch (Exception e) 
          {  
           out.println("error");  
       }  
   }  

}
