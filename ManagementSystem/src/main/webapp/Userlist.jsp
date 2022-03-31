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
	
	<%
UserDaoImpl dao = new UserDaoImpl();
List<User> userList = dao.getAllUsers();

%>

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
				<th>Date of birth</th>
				<th>Action</th>
				<th>Action</th>
</tr>

<tr>
<%
for (User user : userList) {
%>
<td><%=user.getid()%></td>
<td><%=user.getfirstname()%></td>
<td><%=user.getlastname()%></td>
<td><%=user.getusername()%></td>
<td><%=user.getemail()%></td>
<td><%=user.getpass()%></td>
<td><%=user.getmobileno()%></td>
<td><%=user.getgender()%></td>
<td><%=user.getsecurityquestions()%></td>
<td><%=user.getanswer()%></td>
<td><%=user.getdob()%></td>
<td><a href="UserController?action=editform&userId=<%=user.getid()%>">Update</a></td>
<td><a href="UserController?action=delete&userId=<%=user.getid()%>">Delete</a></td>

</tr>
<%
}
//}
%>
</table>
<p><a href="UserController?action=insert">Add User</a></p>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>