package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;
 
public class LoginDao {
     public String authenticateUser(LoginBean loginBean)
     {
         String email = loginBean.getemail(); //Assign user entered values to temporary variables.
         String pass = loginBean.getpass();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String emailDB = "";
         String passDB = "";
 
         try
         {
             con = DBConnection.createConnection();
             statement = con.createStatement(); 
             resultSet = statement.executeQuery("select email,pass from user");
 
             while(resultSet.next())
             {
            	 emailDB = resultSet.getString("email"); 
            	 passDB = resultSet.getString("pass");
 
            	 if(email.equals(emailDB) && pass.equals(passDB))
            	 {
                     return "SUCCESS";
                  }
             }  	
         }
          catch(SQLException e)
          {
                e.printStackTrace();
          }
          return "Invalid user credentials";
         }
     }


