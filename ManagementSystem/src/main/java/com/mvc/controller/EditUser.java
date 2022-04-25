package com.mvc.controller;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.AddressBean;
import com.mvc.bean.User;
import com.mvc.dao.UserDaoImpl;  
 
public class EditUser extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update User</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        
          
        User user = UserDaoImpl.getUserById(id);  
          
        AddressBean address = UserDaoImpl.getAddressbyId(id);
        
        out.print("<form action='EditServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+user.getid()+"'/></td></tr>");  
        out.print("<tr><td>FirstName:</td><td><input type='text' name='firstname' value='"+user.getfirstname()+"'/></td></tr>");
        out.print("<tr><td>LastName:</td><td><input type='text' name='lastname' value='"+user.getlastname()+"'/></td></tr>");
        out.print("<tr><td>UserName:</td><td><input type='text' name='username' value='"+user.getusername()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+user.getemail()+"'/></td></tr>"); 
        out.print("<tr><td>Password:</td><td><input type='password' name='pass' value='"+user.getpass()+"'/>  </td></tr>");
        out.print("<tr><td>Mobile Number:</td><td><input type='number' name='mobileno' value='"+user.getmobileno()+"'/></td></tr>");
        out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+user.getgender()+"'/></td></tr>");
        out.print("<tr><td>Security Questions:</td><td><input type='text' name='securityquestions' value='"+user.getsecurityquestions()+"'/></td></tr>");
        out.print("<tr><td>Answer:</td><td><input type='text' name='answer' value='"+user.getanswer()+"'/></td></tr>");
        out.print("<tr><td>Date of Birth:</td><td><input type='date' name='dob' value='"+user.getdob()+"'/></td></tr>");
      
        out.print("<tr><td>Address Line1:</td><td><input type='text' name='addressline1' value='"+address.getaddressline1()+"'/></td></tr>");
        out.print("<tr><td>Address Line2:</td><td><input type='text' name='addressline2' value='"+address.getaddressline2()+"'/></td></tr>");
        out.print("<tr><td>City:</td><td><input type='text' name='city' value='"+address.getcity()+"'/></td></tr>");
        out.print("<tr><td>Pincode:</td><td><input type='text' name='pincode' value='"+address.getpincode()+"'/></td></tr>");
        out.print("<tr><td>State:</td><td><input type='text' name='state' value='"+address.getstate()+"'/></td></tr>");
        
        out.print("<tr><td>Address Line1:</td><td><input type='text' name='addressline1' value='"+address.getaddressline1()+"'/></td></tr>");
     
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}
