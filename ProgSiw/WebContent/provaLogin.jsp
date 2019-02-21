<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<body>
<div class="container-login100" style="background-image: url('images/sfondo.jpg');" >
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
			

<form action="${pageContext.request.contextPath}/login" method="POST">
	<span class="login100-form-title p-b-37">
						Immetti i tuoi dati
					</span>
		<div class="wrap-input100 validate-input m-b-20" data-validate="Enter email">
						<input class="input100" type="text" name="email" placeholder="email">
						<span class="focus-input100"></span>
					</div>
		<!-- <input type="password" name="password"/> -->
		<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
						<input class="input100" type="password" name="password" placeholder="password">
						<span class="focus-input100"></span>
					</div>
		<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Accedi
						</button>
					</div>
	
					<div class="text-center p-t-57 p-b-20">
						<span class="txt1">
							O accedi con:
						</span>
					</div>
	
					<div class="flex-c p-b-112">
						<a href="#" class="login100-social-item">
							<i class="fa fa-facebook-f"></i>
						</a>
	
						<a href="#" class="login100-social-item">
							<img src="images/icons/icon-google.png" alt="GOOGLE">
						</a>
					</div>
					
					<div class="text-center">
						<a href="index.jsp" class="txt2 hov1">
							Torna alla home
						</a>
					</div>
	
					<div class="text-center">
						<a href="registrazione.jsp" class="txt2 hov1">
							Non sei registrato? Clicca qui
						</a>
					</div>
			</form>
			
		</div>
		</div>

</body>
</html>