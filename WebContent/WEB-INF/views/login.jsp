<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank CRUD</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="style/css/style.css" type="text/css" rel="stylesheet"></link>
<script type="text/javascript">
	function validate() {
		var username = document.loginForm.username.value;
		var password = document.loginForm.password.value;

		if (username == '') {
			alert("Please Enter Username");
			document.loginForm.focus();
			return false;
		} else if (password == '') {
			alert("Please Enter Password");
			document.loginForm.focus();
			return false;
		} else if (password.length < 6) {
			alert("Password should have atleast 6 characters");
			document.loginForm.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<header>
		<div class="logo">Online Banking</div>
		<nav>
			<ul class="nav-area">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="about">About</a></li>
				<li><a href="contact">Contact</a></li>
			</ul>
		</nav>
		<a href="login" class="btn-area">Login</a>
	</header>

	<form name="loginForm" class="box" action="LoginServlet" method="post">
		<h1>Login</h1>
		<input type="text" name="username" placeholder="Login ID"> <input
			type="password" name="password" placeholder="Password"> <span
			style="color: red;">${error}</span> <input type="submit" name=""
			value="Login" onclick="return validate();">
	</form>



	<footer>
		<h1>© 2021 A+ (lka) Fitch Rating - ABC Bank PLC (PQ. 27) is a
			licensed CDE Bank supervised by the Central Bank of Sri Lanka All
			Rights Reserved.Solution by Test</h1>
	</footer>
</body>
</html>