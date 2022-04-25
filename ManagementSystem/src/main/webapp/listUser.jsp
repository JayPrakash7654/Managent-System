<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.mvc.bean.User"%>
<%@ page import="com.mvc.dao.UserDaoImpl"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Directory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	

<div class = "container">
<table class = "table table-striped table-bordered">
<tr class = "thead-dark">
	<th>Id</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>User Name</th>
	<th>Email</th>
	<th>Password</th>
	<th>Mobile Number</th>
	<th>Gender</th>
	<th>SecurityQuestions</th>
	<th>Answer</th>
	<th>Image</th>
				<th>Date of birth</th>
				<th colspan=2>Action</th>
				
</tr>

                  <c:forEach var="user" items="${userlist}" >
                        <tr>
                              <td><c:out value="${user.id}" /></td>
                              <td><c:out value="${user.firstname}" /></td>
                              <td><c:out value="${user.lastname}" /></td>
                              <td><c:out value="${user.username}" /></td>
                              <td><c:out value="${user.email}" /></td>
                              <td><c:out value="${user.pass}" /></td>
                              <td><c:out value="${user.mobileno}" /></td>
                              <td><c:out value="${user.gender}" /></td>
                              <td><c:out value="${user.securityquestions}" /></td>
                              <td><c:out value="${user.answer}" /></td>
                              <td><c:out value="${user.image}" /></td>
                              <td><c:out value="${user.dob}" /></td>
                              <td><a
                                    href="UserController?action=edit&id=<c:out value="${user.id}"/>">Update</a>
                              </td>
                              <td><a
                                    href="UserController?action=delete&id=<c:out value="${user.id}"/>">Delete</a>
                              </td>
                        </tr>
                  </c:forEach>
        


</table>
<p><a href="UserController?action=insert">Add User</a></p>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>