package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.User;
import com.mvc.util.DBConnection;

public class UserDaoImpl {

    private Connection conn;

    public UserDaoImpl() {
    	conn = DBConnection.createConnection();
    }

    public void addUser(User userBean) {
        try {
        	String sql = "INSERT INTO user (firstname, lastname,username, email, pass, mobileno, gender, securityquestions, answer, dob) values (?, ?, ?,?, ?, ?,?, ?, ?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, userBean.getfirstname());
            ps.setString(2, userBean.getlastname());
 		   ps.setString(3, userBean.getusername());
 		   ps.setString(4, userBean.getemail());
 		   ps.setString(5, userBean.getpass());
 		   ps.setString(6, userBean.getmobileno());
 		   ps.setString(7, userBean.getgender());
 		   ps.setString(8, userBean.getsecurityquestions());
 		   ps.setString(9, userBean.getanswer());
 		   ps.setString(10, userBean.getdob());            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM user WHERE id=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editUser(User userBean) {    	
    	try {
    		String sql = "UPDATE user SET firstname = ?, lastname = ?, username = ?, email = ?, pass = ?, mobileno = ?, gender = ?, securityquestions = ?, answer = ?, dob = ?" +
            " WHERE id=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, userBean.getfirstname());
            ps.setString(2, userBean.getlastname());
 		   ps.setString(3, userBean.getusername());
 		   ps.setString(4, userBean.getemail());
 		   ps.setString(5, userBean.getpass());
 		   ps.setString(6, userBean.getmobileno());
 		   ps.setString(7, userBean.getgender());
 		   ps.setString(8, userBean.getsecurityquestions());
 		   ps.setString(9, userBean.getanswer());
 		   ps.setString(10, userBean.getdob()); 
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List getAllUsers() {
        List users = new ArrayList();
        try {
        	String sql = "SELECT * FROM user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User userBean = new User();
                userBean.setfirstname(rs.getString("firstname"));
                userBean.setlastname(rs.getString("lastname"));
                userBean.setusername(rs.getString("username"));
                userBean.setemail(rs.getString("email"));
                userBean.setpass(rs.getString("pass"));
                userBean.setmobileno(rs.getString("mobileno"));
                userBean.setgender(rs.getString("gender"));
                userBean.setsecurityquestions(rs.getString("securityquestions"));
                userBean.setanswer(rs.getString("answer"));
                userBean.setdob(rs.getString("dob"));
                userBean.setpass(rs.getString("pass"));                           
                users.add(userBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserById(int userId) {
    	User userBean = new User();
        try {
        	String sql = "SELECT * FROM user WHERE id=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userBean.setfirstname(rs.getString("firstname"));
                userBean.setlastname(rs.getString("lastname"));
                userBean.setusername(rs.getString("username"));
                userBean.setemail(rs.getString("email"));
                userBean.setpass(rs.getString("pass"));
                userBean.setmobileno(rs.getString("mobileno"));
                userBean.setgender(rs.getString("gender"));
                userBean.setsecurityquestions(rs.getString("securityquestions"));
                userBean.setanswer(rs.getString("answer"));
                userBean.setdob(rs.getString("dob"));
                userBean.setpass(rs.getString("pass"));                          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
	}

}
