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
 
public class EditServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String username=request.getParameter("username");  
        String email=request.getParameter("email"); 
        String pass=request.getParameter("pass");
        String mobileno =request.getParameter("mobileno");
        String gender=request.getParameter("gender");
        String securityquestions =request.getParameter("securityquestions");
        String answer =request.getParameter("answer");
        String dob = request.getParameter("dob");
        
        String addressline1 = request.getParameter("addressline1");
        String addressline2 = request.getParameter("addressline2");
        
        
        User user=new User();
        AddressBean address = new AddressBean();
        user.setid(id);  
        user.setfirstname(firstname); 
        user.setlastname(lastname);
        user.setusername(username);  
        user.setemail(email);
        user.setpass(pass);
        user.setmobileno(mobileno);
        user.setgender(gender);
        user.setsecurityquestions(securityquestions);
        user.setanswer(answer);
        user.setdob(dob);
        address.setaddressline1(addressline1);
        address.setaddressline2(addressline2);
          
        int status=UserDaoImpl.updateUser(user);  
        if(status>0){  
            response.sendRedirect("ShowRecord");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}