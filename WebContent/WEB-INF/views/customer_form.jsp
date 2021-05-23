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
		document.getElementById("accountnumber").value = Math.floor((Math.random() * 10000000000) + 1);
		document.getElementById("password").value = '_'+ Math.random().toString(36).substr(2, 9);
	}

	function validateEmail(email) {
		var re = /\S+@\S+\.\S+/;
		return re.test(email);
	}

	function validate() {
		var name = document.CustomerForm.name.value;
		var email = document.CustomerForm.email.value;
		var nic = document.CustomerForm.nic.value;
		var address = document.CustomerForm.address.value;
		var phonenumber = document.CustomerForm.phonenumber.value;
		var eid = document.CustomerForm.eid.value;
		var password = document.CustomerForm.password.value;

		if (name == '') {
			alert("Please Enter name");
			document.loginForm.focus();
			return false;
		}  else if (nic == '') {
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
		document.forms['CustomerForm'].submit();
	}
</script>
</head>

<body>
	<header>
		<nav
			class="navbar navbar-expand-md navbar-dark d-flex justify-content-between"
			style="background-color: black">
			<div>
				<a href="employeeDashboard" class="navbar-brand"> Employee Dashboard </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="employeeDashboard" class="nav-link">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5" style="margin-bottom: 25px;">
		<div class="card" style="background-color: #077058;">
			<div class="card-body">
				<form method="post" action="AddCustomer" name="CustomerForm">
					<fieldset class="form-group">
						<label>Full Name</label> <input type="text" class="form-control"
							name="name">
					</fieldset>

					<fieldset class="form-group">
						<label>Account Number</label> <input id="accountnumber" type="text" class="form-control"
							name="accountnumber" readonly="readonly">
					</fieldset>

					<fieldset class="form-group">
						<label>NIC</label> <input type="text" class="form-control"
							name="nic">
					</fieldset>

					<fieldset class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input type="text"
							class="form-control" name="address">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Phone Number</label> <input type="number"
							class="form-control" name="phonenumber">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Account Balance</label> <input type="number"
							class="form-control" name="accountbalance">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Account Status</label> <input style="width: 20px;height: 20px; margin-top: 20px;" type="checkbox"
							 name="status">
					</fieldset>
					
					<fieldset class="form-group">
						<input id="password"
							 name="password" type="hidden">
					</fieldset>

					<button  type="submit"
						class="btn btn-warning">Save</button>
					&nbsp;&nbsp;&nbsp;
				</form>
				<div style="text-align: center;">
				<button onclick="return  generateId();" type="submit"
					class="btn btn-primary">Generate Account Number</button>
				</div>				
			</div>
		</div>
	</div>
</body>
</html>