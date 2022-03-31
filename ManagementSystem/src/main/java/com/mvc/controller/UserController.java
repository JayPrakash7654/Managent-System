package com.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mvc.dao.UserDaoImpl;
import com.mvc.bean.User;;


public class UserController extends HttpServlet {    
    private static String INSERT = "/Addnew.jsp";
    private static String Edit = "/edit.jsp";
    private static String UserRecord = "/Userlist.jsp";
    private UserDaoImpl dao;

    public UserController() {
        super();
        dao = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String uId = request.getParameter("id");        
        String action = request.getParameter("action");
        if(!((uId)== null) && action.equalsIgnoreCase("insert"))
        {
        	int id = Integer.parseInt(uId);
        	User user = new User();
        	user.setId(id);
        	user.setfirstname(request.getParameter("firstname"));
        	user.setlastname(request.getParameter("lastname"));
        	user.setusername(request.getParameter("username"));
        	user.setemail(request.getParameter("email"));
        	user.setpass(request.getParameter("pass"));
        	user.setmobileno(request.getParameter("mobileno"));
        	user.setgender(request.getParameter("gender"));
        	user.setsecurityquestions(request.getParameter("securityquestions"));
        	user.setanswer(request.getParameter("answer"));
        	user.setdob(request.getParameter("dob"));
        	dao.addUser(user);
        	redirect = UserRecord;
            request.setAttribute("user", dao.getAllUsers());    
           	System.out.println("Record Added Successfully");
        }
        
        else if (action.equalsIgnoreCase("delete")){
            String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            dao.removeUser(uid);
            redirect = UserRecord;
            request.setAttribute("user", dao.getAllUsers());
            System.out.println("Record Deleted Successfully");
            
        }else if (action.equalsIgnoreCase("editform")){        	
        	redirect = Edit;  
        	
        } else if (action.equalsIgnoreCase("edit")){
        	String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);   
            
            User user = new User();
        	user.setId(uid);
        	user.setfirstname(request.getParameter("firstname"));
        	user.setlastname(request.getParameter("lastname"));
        	user.setusername(request.getParameter("username"));
        	user.setemail(request.getParameter("email"));
        	user.setpass(request.getParameter("pass"));
        	user.setmobileno(request.getParameter("mobileno"));
        	user.setgender(request.getParameter("gender"));
        	user.setsecurityquestions(request.getParameter("securityquestions"));
        	user.setanswer(request.getParameter("answer"));
        	user.setdob(request.getParameter("dob"));
            dao.editUser(user);
            request.setAttribute("user", user);
            redirect = UserRecord;
            
            System.out.println("Record updated Successfully");
            
         } else if (action.equalsIgnoreCase("listUser")){
            redirect = UserRecord;
            
            request.setAttribute("user", dao.getAllUsers());
            
         } else {
            redirect = INSERT;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

