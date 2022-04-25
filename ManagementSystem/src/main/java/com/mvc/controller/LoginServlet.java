package com.mvc.controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;
 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
 
        LoginBean loginBean = new LoginBean(); 
 
        loginBean.setemail(email); 
         loginBean.setpass(pass);
 
        LoginDao loginDao = new LoginDao(); 
 
        String userValidate = loginDao.authenticateUser(loginBean); 
 
        if(userValidate.equals("SUCCESS")) 
         {
        	HttpSession session=request.getSession();   
            session.setAttribute("email", email);
            response.sendRedirect("Home.jsp");
      
         }
         else
         {
             request.setAttribute("errMessage", userValidate); 
             request.getRequestDispatcher("/index.html").forward(request, response);
         }
    }
}