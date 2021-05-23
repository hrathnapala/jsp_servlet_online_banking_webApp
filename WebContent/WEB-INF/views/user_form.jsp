<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="style/css/adminStyle.css" type="text/css" rel="stylesheet"></link>
<script type="text/javascript">
	function generateId() {
		document.getElementById("eid").value = '_'
				+ Math.random().toString(36).substr(2, 9);
	}

	function validateEmail(email) {
		var re = /\S+@\S+\.\S+/;
		return re.test(email);
	}

	function validate() {
		var name = document.EmployeeForm.name.value;
		var email = document.EmployeeForm.email.value;
		var nic = document.EmployeeForm.nic.value;
		var address = document.EmployeeForm.address.value;
		var phonenumber = document.EmployeeForm.phonenumber.value;
		var eid = document.EmployeeForm.eid.value;
		var password = document.EmployeeForm.password.value;

		if (name == '') {
			alert("Please Enter name");
			document.loginForm.focus();
			return false;
		} else if (email == '') {
			alert("Please Enter email");
			document.loginForm.focus();
			return false;
		} else if (nic == '') {
			alert("Please Enter nic");
			document.loginForm.focus();
			return false;
		} else if (nic.length !== 10) {
			alert("Invalid nic");
			document.loginForm.focus();
			return false;
		}else if (address == '') {
			alert("Please Enter address");
			document.loginForm.focus();
			return false;
		} else if (phonenumber == '') {
			alert("Please Enter phonenumber");
			document.loginForm.focus();
			return false;
		}  else if (password == '') {
			alert("Please Enter password");
			document.loginForm.focus();
			return false;
		} else if (password.length < 6) {
			alert("Password should have atleast 6 characters");
			document.loginForm.focus();
			return false;
		}else if (eid == '') {
			alert("Please Generate Employee ID");
			document.loginForm.focus();
			return false;
		}
		else if (!validateEmail(email)) {
			alert("Invalid Email");
			document.loginForm.focus();
			return false;
		}
		document.forms['EmployeeForm'].submit();
	}
</script>
</head>

<body>
	<header>
		<nav
			class="navbar navbar-expand-md navbar-dark d-flex justify-content-between"
			style="background-color: black">
			<div>
				<a href="adminPage" class="navbar-brand"> Admin Dashboard </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="adminPage" class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5" style="margin-bottom: 25px;">
		<div class="card" style="background-color: #077058;">
			<div class="card-body">
				<form method="post" action="AddUserServlet" name="EmployeeForm" onsubmit="event.preventDefault(); validate();">
					<fieldset class="form-group">
						<label>Full Name</label> <input type="text" class="form-control"
							name="name">
					</fieldset>

					<fieldset class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>NIC</label> <input type="text" class="form-control"
							name="nic">
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input type="text" class="form-control"
							name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Phone Number</label> <input type="text"
							class="form-control" name="phonenumber">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Password</label> <input type="text"
							class="form-control" name="password">
					</fieldset>

					<fieldset class="form-group">
						<label>Employee ID</label> <input id="eid" type="text"
							class="form-control" name="eid" readonly="readonly">
					</fieldset>
					<button  type="submit"
						class="btn btn-warning">Save</button>
					&nbsp;&nbsp;&nbsp;
				</form>
				<div style="text-align: center;">
				<button onclick="return  generateId();" type="submit"
					class="btn btn-primary">Generate Employee id</button>
				</div>				
			</div>
		</div>
	</div>
</body>
</html>
