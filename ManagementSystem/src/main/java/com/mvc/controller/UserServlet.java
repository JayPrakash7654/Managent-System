package com.mvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


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
		    request.getRequestDispatcher("Message.jsp").forward(request, response);
		   }
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	}

}
