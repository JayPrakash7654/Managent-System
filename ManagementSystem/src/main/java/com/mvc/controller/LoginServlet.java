package com.mvc.controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;
 
public class LoginServlet extends HttpServlet {
 
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
             request.setAttribute("email", email);
             request.getRequestDispatcher("/Home.jsp").forward(request, response);
         }
         else
         {
             request.setAttribute("errMessage", userValidate); 
             request.getRequestDispatcher("/index.html").forward(request, response);
         }
    }
}