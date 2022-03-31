<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Register User</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form" action="UserServlet" enctype="multipart/form-data" name="form" method="post" >
					<span class="login100-form-title">
						Register User
					</span>

					<div class="wrap-input100">
						<input class="input100" type="text" name="firstname" placeholder="First name"  required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100">
						<input class="input100" type="text" name="lastname" placeholder="Last name" required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100">
						<input class="input100" type="text" name="username" placeholder="User name" required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100">
						<input class="input100" type="email" name="email" placeholder="Email" required>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="password" name="pass" placeholder="Password" required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100">
						<input class="input100" type="number" name="mobileno" placeholder="Mobile No." required>
						<span class="focus-input100"></span>
					</div>
					
					 <div class="wrap-input100 input100">
					 <label>Gender:</label><br>
						<input type="radio" value="M" name="gender">M 
						<input type="radio" value="F" name="gender">F
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
					
					<div class="wrap-input100 input100 ">
						<label for="dob">Enter DOB.</label>
 						<input  type="date" id="dob" name="dob" required>
					</div>
					
					<div class="wrap-input100">
						<input class="input100" type="file" name="image" required>
						<span class="focus-input100"></span>
					</div>	
				
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Register
						</button>
					</div>


					<div class="text-center p-t-136">
						<a class="txt2" href="index.html"> Already have a Account,Login </a>
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>