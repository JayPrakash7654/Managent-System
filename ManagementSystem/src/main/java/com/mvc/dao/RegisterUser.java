package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Blob;

import com.mvc.bean.User;
import com.mvc.util.DBConnection;

public class RegisterUser {
	public String registerUser(User registerBean)
    {
		String firstname = registerBean.getfirstname();
        String lastname = registerBean.getlastname();
        String username = registerBean.getusername();
        String email = registerBean.getemail();
        String pass = registerBean.getpass();
        String mobileno = registerBean.getmobileno();
        String gender = registerBean.getgender();
        String securityquestions = registerBean.getsecurityquestions();
        String answer = registerBean.getanswer();
        String dob = registerBean.getdob();
        Blob image = registerBean.getimage();
        
        Connection con = null;
        PreparedStatement preparedStatement = null;         
        try
        {
            con = DBConnection.createConnection();
            String query = "INSERT INTO user (firstname, lastname,username, email, pass, mobileno, gender, securityquestions, answer, dob, image) values (?, ?, ?,?, ?, ?,?, ?, ?,?, ?)";
            preparedStatement  = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, pass);
            preparedStatement.setString(6, mobileno);
            preparedStatement.setString(7, gender);
            preparedStatement.setString(8, securityquestions);
            preparedStatement.setString(9, answer);
            preparedStatement.setString(10, dob);
            preparedStatement.setBlob(11, image);
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";


    }
}