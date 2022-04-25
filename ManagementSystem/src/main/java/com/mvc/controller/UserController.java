package com.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mvc.bean.User;
import com.mvc.dao.UserDaoImpl;


public class UserController extends HttpServlet {    
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/EditUser";
    private static String LIST_USER = "/ShowRecord";
    private UserDaoImpl dao;

    public UserController() {
        super();
        dao = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", UserDaoImpl.getAllUsers());   
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = UserDaoImpl.getUserById(userId);
            request.setAttribute("userlist", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("userlist", UserDaoImpl.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

}

    	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	User user = new User();
    	user.setfirstname(request.getParameter("firstname"));
    	user.setlastname(request.getParameter("lastname"));
    	user.setusername(request.getParameter("username"));
    	user.setemail(request.getParameter("email"));
    	user.setpass(request.getParameter("pass"));
    	user.setmobileno(request.getParameter("mobileno"));
    	user.setgender(request.getParameter("gender"));
    	user.setsecurityquestions(request.getParameter("securityquestions"));
    	user.setanswer(request.getParameter("answer"));
    	 Part part = request.getPart("image");
		  if(part!=null){
		   System.out.println(part.getName());
		            System.out.println(part.getSize());
		            System.out.println(part.getContentType());
		  }
    	user.setdob(request.getParameter("dob"));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
              dao.addUser(user);
        }
        else
        {
              user.setid(Integer.parseInt(id));
              UserDaoImpl.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("user", UserDaoImpl.getAllUsers());
        view.forward(request, response);

}


    }


