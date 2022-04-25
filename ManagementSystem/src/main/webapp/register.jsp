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
	<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.3.1/minty/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/select2/3.3.2/select2.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.css">
    <style>
        body{background-color:#F9F9FC;font-family: 'Roboto', sans-serif;font-size:14px;}
        .select2-container {
            padding: 0;
            border: none;
        }
        h3{margin-bottom:0;}
        .card{box-shadow: 0 0 13px 0 rgba(82,63,105,.05);background-color: #fafafa;margin-bottom: 20px;border-radius: 4px;padding: 20px;}
        .select2-choice {
            display: block;
            width: 100%;
            height: calc(1.5em + .75rem + 2px) !important;
            padding: .375rem .75rem !important;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5 !important;
            color: #495057;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: .25rem;
            transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
        }
    </style>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
				<br><br><br><br><br><br><br><br><br><br><br><br><br>
					<img src="images/img-01.png" alt="IMG">
					<br><br><br><br><br>
					<h2>Webapp Project</h2>
    
    				<p>If you are new, Register here.</p>
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
					
					 <div id="main-container">
                    <div class="panel card container-item">
                        <div class="panel-body">
                            <div class="panel-body">
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label" for="address_line_one_0">Address line 1</label>
                                            <input type="text" id="address_line_one_0" class="form-control" name="addressline1" maxlength="255">
                                            <p class="help-block help-block-error"></p>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label" for="address_line_two_0">Address line 2</label>
                                            <input type="text" id="address_line_two_0" class="form-control" name="addressline2" maxlength="255">
                                            <p class="help-block help-block-error"></p>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label" for="city_0">City</label>
                                            <input type="text" id="city_0" class="form-control" name="city" maxlength="64">
                                            <p class="help-block help-block-error"></p>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label" for="pincode_0">Pin Code</label>
                                            <input type="text" id="pincode" class="form-control" name="pincode" maxlength="64">
                                            <p class="help-block help-block-error"></p>
                                        </div>
                                    </div>
                                     <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label" for="state_0">State</label>
                                            <input type="text" id="state_0" class="form-control" name="state" maxlength="64">
                                            <p class="help-block help-block-error"></p>
                                        </div>
                                    </div>
                                   
                                            <a href="javascript:void(0)" class="remove-item btn btn-sm btn-danger remove-social-media">Remove</a>
                                        	
                            </div>
                        </div>
                    </div>
                </div> 
				
				<div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <a class="btn btn-success btn-sm" id="add-more" href="javascript:;" role="button"><i class="fa fa-plus"></i>Add more address</a>
                                                                 
                                    </div>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/3.3.2/select2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.js"></script>
<script src="https://cdn.ckeditor.com/4.5.1/standard/ckeditor.js"></script>
<script src="js/cloneData.js" type="text/javascript"></script>
<script src="js/address.js"></script>

</body>
</html>