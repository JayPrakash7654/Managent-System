package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.AddressBean;
import com.mvc.bean.User;
import com.mvc.util.DBConnection;

public class UserDaoImpl {
	
    private Connection conn;

    public UserDaoImpl() {
    	conn = DBConnection.createConnection();
    }

    public void addUser(User user) {
        Connection con=null;
        try {
             
              con = DBConnection.createConnection();
              PreparedStatement pStmt = con
                      .prepareStatement("insert into user(firstname, lastname,username, email, pass, mobileno, gender, securityquestions, answer,image, dob) values (?, ?, ?, ?,?, ?, ?,?, ?, ?,?)");

              pStmt.setString(1, user.getfirstname());
              pStmt.setString(2, user.getlastname());
              pStmt.setString(3, user.getusername());
              pStmt.setString(4, user.getemail());
              pStmt.setString(5, user.getpass());
              pStmt.setString(6, user.getmobileno());
              pStmt.setString(7, user.getgender());
              pStmt.setString(8, user.getsecurityquestions());
              pStmt.setString(9, user.getanswer());
              pStmt.setBlob(10, user.getimage());
              pStmt.setString(11, user.getdob());
              pStmt.executeUpdate();

          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
        	  DBConnection.closeConnection(con);
          }
      }

    
    

    public void deleteUser(int userId) {
        Connection con = null;
        try {
              con = DBConnection.createConnection();
              PreparedStatement pStmt = con.prepareStatement("delete from user where id=?");
             
              pStmt.setInt(1, userId);
              pStmt.executeUpdate();

          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
        	  DBConnection.closeConnection(conn);
          }
      }

    public static int updateUser(User user) {
    	int status=0;
        Connection con = null;
        try {
              con = DBConnection.createConnection();
              PreparedStatement pStmt = con.prepareStatement("update user set firstname = ?, lastname = ?, username = ?, email = ?, pass = ?, mobileno = ?, gender = ?, securityquestions = ?, answer = ?, image = ?, dob = ?  where id=?");

              pStmt.setString(1, user.getfirstname());
              pStmt.setString(2, user.getlastname());
              pStmt.setString(3, user.getusername());
              pStmt.setString(4, user.getemail());
              pStmt.setString(5, user.getpass());
              pStmt.setString(6, user.getmobileno());
              pStmt.setString(7, user.getgender());
              pStmt.setString(8, user.getsecurityquestions());
              pStmt.setString(9, user.getanswer());
              pStmt.setBlob(10, user.getimage());
              pStmt.setString(11, user.getdob());
              pStmt.setInt(12,user.getid());
              status= pStmt.executeUpdate();

          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
        	  DBConnection.closeConnection(con);
          }
		return status;
      }
    
    public static List<User> getAllUsers() {
        Connection con = null;
          List<User> userlist = new ArrayList<User>();
          try {
              con = DBConnection.createConnection();
              Statement stmt = con.createStatement();
              ResultSet rSet = stmt.executeQuery("select * from user");
              while (rSet.next()) {
                  User users = new User();
                  users.setid(rSet.getInt("id"));
                  users.setfirstname(rSet.getString("firstname"));
                  users.setlastname(rSet.getString("lastname"));
                  users.setusername(rSet.getString("username"));
                  users.setemail(rSet.getString("email"));
                  users.setpass(rSet.getString("pass"));
                  users.setmobileno(rSet.getString("mobileno"));
                  users.setgender(rSet.getString("gender"));
                  users.setsecurityquestions(rSet.getString("securityquestions"));
                  users.setanswer(rSet.getString("answer"));
                  users.setimage(rSet.getBlob("image"));
                  users.setdob(rSet.getString("dob"));
                  userlist.add(users);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
        	  DBConnection.closeConnection(con);
          }

          return userlist;
      }
    
    

    public static User getUserById(int id) {
        Connection con = null;
          User user = new User();
          try {
              con = DBConnection.createConnection();
              PreparedStatement pStmt = con.prepareStatement("select * from user where id=?");
              pStmt.setInt(1, id);
              ResultSet rSet = pStmt.executeQuery();

              if (rSet.next()) {
                  user.setid(rSet.getInt("id"));
                  user.setfirstname(rSet.getString("firstname"));
                  user.setlastname(rSet.getString("lastname"));
                  user.setusername(rSet.getString("username"));
                  user.setemail(rSet.getString("email"));
                  user.setpass(rSet.getString("pass"));
                  user.setmobileno(rSet.getString("mobileno"));
                  user.setgender(rSet.getString("gender"));
                  user.setsecurityquestions(rSet.getString("securityquestions"));
                  user.setanswer(rSet.getString("answer"));
                  user.setimage(rSet.getBlob("image"));
                  user.setdob(rSet.getString("dob"));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
        	  DBConnection.closeConnection(con);
          }

          return user;
      }
    
    public static AddressBean getAddressbyId(int userid) {
        Connection con = null;
          AddressBean address = new AddressBean();
          try {
              con = DBConnection.createConnection();
              PreparedStatement pStmt = con.prepareStatement("select * from address1 where userid=?");
              pStmt.setInt(1, userid);
              ResultSet rSet = pStmt.executeQuery();

              if (rSet.next()) {
                  
                  address.setaddressline1(rSet.getString("addressline1"));
                  address.setaddressline2(rSet.getString("addressline2"));
                  address.setcity(rSet.getString("city"));
                  address.setpincode(rSet.getString("pincode"));
                  address.setstate(rSet.getString("state"));
                  
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }finally{
        	  DBConnection.closeConnection(con);
          }

          return address;
      }
    
  }

