package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.util.DBConnection;


public class RetriveImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection connection = DBConnection.createConnection();
    ResultSet rs = null;
    PreparedStatement psmnt = null;           
	InputStream sImage;
 
    try {
    	String id = req.getQueryString();
        psmnt = connection.prepareStatement("SELECT image FROM user WHERE id = ?");

        psmnt.setInt(1,Integer.parseInt(id));
        rs = psmnt.executeQuery();
        if(rs.next()) {
              byte[] bytearray = new byte[1048576];
              int size=0;
              sImage = rs.getBinaryStream(1);
              //response.reset();
              resp.setContentType("image/jpeg");

              while((size=sImage.read(bytearray))!= -1 ){

                    resp.getOutputStream().write(bytearray,0,size);
		      }
	    }
    }
    catch(Exception ex){
		ex.printStackTrace();
    }

}

}
