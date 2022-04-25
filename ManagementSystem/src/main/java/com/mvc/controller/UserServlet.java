package com.mvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.mvc.service.*;
import com.mvc.bean.AddressBean;
import com.mvc.bean.User;
import com.mvc.util.DBConnection;


@MultipartConfig(maxFileSize=16177215)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		  int id = Integer.parseInt(request.getParameter("id"));
		  Connection conn = DBConnection.createConnection();
		  String sql = "SELECT * FROM user WHERE id ='"+id+"'";
		  PreparedStatement ps;
		  try {
		   ps = conn.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()){
		    byte [] imageData = rs.getBytes("image"); // extract byte data from the resultset..
		    OutputStream os = response.getOutputStream(); // output with the help of outputStream 
		             os.write(imageData);
		             os.flush();
		             os.close();
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		   response.getOutputStream().flush();
		   response.getOutputStream().close();
		  }
		  
		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getParameter("action");
	    if("Insert".equals(action)) 
	    {
		String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String mobileno = request.getParameter("mobileno");
        String gender = request.getParameter("gender");
        String securityquestions = request.getParameter("securityquestions");
        String answer = request.getParameter("answer");
        String dob = request.getParameter("dob");    

		  InputStream inputStream = null ;//input stream of uploaded file
		  Part part = request.getPart("image");
		  if(part!=null){
		   System.out.println(part.getName());
		            System.out.println(part.getSize());
		            System.out.println(part.getContentType());
		            inputStream = part.getInputStream();
		  }
		  
//user multiple address
		  
		  String add_1[]=request.getParameterValues("addressline1"); 
		  String add_2[]=request.getParameterValues("addressline2");
		  String City[]=request.getParameterValues("city");
		  String Pincode[]=request.getParameterValues("pincode"); 
		  String State[]=request.getParameterValues("state");
		  
		  for(int i=0; i<add_1.length; i++)
		  {
		  
			  System.out.println("for loop before"+i);
			  String addressline1=add_1[i];
			  String addressline2=add_2[i];
			  String city=City[i]; 
			  String pincode=Pincode[i]; 
			  String state=State[i];
			  System.out.println("for loop after"+i);
			  System.out.println("address:-"+addressline1); 
			  
			  AddressBean abean =new AddressBean(addressline1,addressline2,city,pincode,state);
			  UserAddress addressdao=new UserAddressImpl();
			  addressdao.insertUserAddress(abean);
		  }
		  
		  
		  // Now Create a connection and send it to DB...
		  Connection conn = DBConnection.createConnection();
		  String sql = "INSERT INTO user (firstname, lastname,username, email, pass, mobileno, gender, securityquestions, answer, dob, image) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?)";
		  try {
		   PreparedStatement ps = conn.prepareStatement(sql);
		 
		   ps.setString(1, firstname);
		   ps.setString(2, lastname);
		   ps.setString(3, username);
		   ps.setString(4, email);
		   ps.setString(5, pass);
		   ps.setString(6, mobileno);
		   ps.setString(7, gender);
		   ps.setString(8, securityquestions);
		   ps.setString(9, answer);
		   ps.setString(10, dob);
		   ps.setBlob(11, inputStream);
		   
		   int i = ps.executeUpdate();
			 
		   if(i > 0){
		    request.setAttribute("success", "User Added Successfully");
		    response.sendRedirect("register.jsp");
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		   
	    }
	    
		  else if("Update".equals(action))
		    {
		    	 String id=request.getParameter("id");
		    	 String firstname = request.getParameter("firstname");
		    	 String lastname = request.getParameter("lastname");
		         String username = request.getParameter("username");
		         String email = request.getParameter("email");
		         String pass = request.getParameter("pass");
		         String mobileno = request.getParameter("mobileno");
		         String gender = request.getParameter("gender");
		         String securityquestions = request.getParameter("securityquestions");
		         String answer = request.getParameter("answer");
		         String dob = request.getParameter("dob");    

		 		  InputStream inputStream = null ;//input stream of uploaded file
		 		  Part part = request.getPart("image");
		 		  if(part!=null){
		 		   System.out.println(part.getName());
		 		            System.out.println(part.getSize());
		 		            System.out.println(part.getContentType());
		 		            inputStream = part.getInputStream();
		 		  }
				System.out.println(id);
				User user = new User();
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
			     
				UserService userdao = new UserServiceImpl();
				userdao.updateUser(user);
				
				//Update Address
				
				 String add_1[]=request.getParameterValues("addressline1"); 
				  String add_2[]=request.getParameterValues("addressline2");
				  String City[]=request.getParameterValues("city");
				  String Pincode[]=request.getParameterValues("pincode"); 
				  String State[]=request.getParameterValues("state");
				  String add_rm[]=request.getParameterValues("remove");
				  
				  for(int i=0; i<add_1.length; i++)
				  {
				  
					  System.out.println("for loop before"+i);
					  String addressline1=add_1[i];
					  String addressline2=add_2[i];
					  String city=City[i]; 
					  String pincode=Pincode[i]; 
					  String state=State[i];
					  String remove=add_rm[i];
					  System.out.println("remove id"+remove);
					  System.out.println("for loop after"+i);
					  System.out.println("address:-"+addressline1); 
					  
					  AddressBean abean =new AddressBean();
					  abean.setaddressline1(addressline1);  
					  abean.setaddressline2(addressline2);
					  abean.setcity(city);  
					  abean.setpincode(pincode);  
					  abean.setstate(state); 
					  UserAddress addressdao=new UserAddressImpl();
					  addressdao.UpdateUserAddress(abean);	
					  
				  }
				
		    }
		  
		  
		 
		  
		  
	}

}
