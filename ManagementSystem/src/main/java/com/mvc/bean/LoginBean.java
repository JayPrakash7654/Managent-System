package com.mvc.bean;
 
public class LoginBean
{
     private String email;
     private String pass;
 
    public String getemail() {
        return email;
     }
    public void setemail(String email) {
        this.email = email;
     }
     public String getpass() {
        return pass;
     }
     public void setpass(String pass) {
        this.pass = pass;
     }
}