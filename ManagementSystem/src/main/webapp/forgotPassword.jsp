<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>ForgotPassword</title>
</head>
<body>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					
					<c:set var="msg" value="done"/>
					<c:if test="${msg == done}">
   					<c:out value="Password Changed Successfully!"/>
					</c:if>
					
					<%-- <%
   						String msg=request.getParameter("msg");
   						if("done".equals(msg))
  						 {
				   	%>
	   				<h1>Password Changed Successfully!</h1>
   					<%} %>
   					<%
  					 if("invalid".equals(msg))
  					 {
	 				 %>
	  				<h1>Some thing Went Wrong! Try Again !</h1> 
   					<%} %> --%>
   					<img src="images/img-01.png" alt="IMG">
					<br><br><br><br><br>
    				<h2>Webapp Project</h2>
    
    				<p>If user forgot their password, from here they can change it.</p>
				</div>
     <form action="ForgotPasswordAction" method="post">
     <span class="login100-form-title">
						Change your Password
					</span>
     <div class="wrap-input100">
     	<input class="input100" type="email" name="email" placeholder="Enter Email" required>
     	<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100">
     	<input class="input100" type="number" name="mobileno" placeholder="Enter Mobile No." required>
     	<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100">
     <select class="input100" name="securityquestions" required>
			<option value="Which was your first car">Which was your first Car </option>
			<option value="What is the name of your hometown">What is the name of your HomeTown </option>
			<option value="What is your favourite animal">What is your favorite Animal </option>
	</select>
	<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100">
		<input class="input100" type="text" name="answer" placeholder="Enter Answer" required>
		<span class="focus-input100"></span>
	</div>
	<div class="wrap-input100">
		<input class="input100"type="password" name="newpass" placeholder="Enter new password" required>
		<span class="focus-input100"></span>
	</div>
	
	<div class="container-login100-form-btn">
		<button class="login100-form-btn"> Save </button>
	</div>
	<div class="text-center p-t-136">
						<a class="txt2" href="index.html"> Login </a>
					</div>
     </form>
  </div>
</div>
</div>
</body>
</html>