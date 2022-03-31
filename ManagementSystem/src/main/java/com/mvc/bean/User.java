package com.mvc.bean;

import java.sql.Blob;

public class User {
 private int id;
 private String firstname;
 private String lastname;
 private String username;
 private String email;
 private String pass;
 private String mobileno;
 private String gender;
 private String securityquestions;
 private String answer;
 private String dob;
 private Blob image;
 public int getid() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getfirstname() {
  return firstname;
 }
 public void setfirstname(String firstname) {
  this.firstname = firstname;
 }
 
 public String getlastname() {
	 return lastname;
}
public void setlastname(String lastname) {
	 this.lastname = lastname;
}

public String getusername() {
	return username;
}
public void setusername(String username) {
	this.username = username;
}

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

public String getmobileno() {
	return mobileno;
}
public void setmobileno(String mobileno) {
	this.mobileno = mobileno;
}

public String getgender() {
	return gender;
}
public void setgender(String gender) {
	this.gender = gender;
}
	 
public String getsecurityquestions() {
	return securityquestions;
}
public void setsecurityquestions(String securityquestions) {
	this.securityquestions = securityquestions;
}	 
		 
 public String getanswer() {
  return answer;
 }
 public void setanswer(String answer) {
  this.answer = answer;
 }
 public String getdob() {
  return dob;
 }
 public void setdob(String dob) {
  this.dob = dob;
 }
 public Blob getimage() {
  return image;
 }
 public void setimage(Blob image) {
  this.image = image;
 } 
 @Override
 public String toString() {
 return "User [id=" + id + ", firstname=" + firstname
 + ", lastname=" + lastname + ",username=" + username + ", email=" + email + ", pass=" + pass + ", mobileno=" + mobileno + ", gender=" + gender + ", securityquestions=" + securityquestions + ", answer=" + answer + ", dob=" + dob + "]";
 }
}