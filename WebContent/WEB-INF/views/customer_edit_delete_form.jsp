<%@page import="com.obs.model.CustomerModel"%>
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
	
function validateEmail(email) {
	var re = /\S+@\S+\.\S+/;
	return re.test(email);
}

function validate() {
	var name = document.CustomerForm.name.value;
	var accountnumber = document.CustomerForm.accountnumber.value;
	var nic = document.CustomerForm.nic.value;
	var email = document.CustomerForm.email.value;
	var address = document.CustomerForm.address.value;
	var phonenumber = document.CustomerForm.phonenumber.value;
	var accountbalance = document.CustomerForm.accountbalance.value;

	if (name == '') {
		alert("Please Enter name");
		document.CustomerForm.focus();
		return false;
	}  else if (nic == '') {
		alert("Please Enter nic");
		document.CustomerForm.focus();
		return false;
	} else if (nic.length !== 10) {
		alert("Invalid nic");
		document.CustomerForm.focus();
		return false;
	}else if (email == '') {
		alert("Please Enter Email");
		document.CustomerForm.focus();
		return false;
	} else if (address == '') {
		alert("Please Enter Address");
		document.CustomerForm.focus();
		return false;
	}  else if (phonenumber == '') {
		alert("Please Enter Phone Number");
		document.CustomerForm.focus();
		return false;
	} else if (accountbalance == '') {
		alert("Please Enter Amount");
		document.CustomerForm.focus();
		return false;
	}else if (accountnumber == '') {
		alert("Please Generate Account Number");
		document.CustomerForm.focus();
		return false;
	}
	else if (!validateEmail(email)) {
		alert("Invalid Email");
		document.CustomerForm.focus();
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
				<%
				CustomerModel c1 = (CustomerModel) request.getAttribute("um");
				%>

				<%
				if (request.getAttribute("error") != null) {
				%>
				<div class="error">${error}</div>
				<%
				}
				%>
				<form method="post" action="EditCustomer" name="CustomerForm" onsubmit="event.preventDefault(); validate();">
					<fieldset class="form-group">
						<label>Full Name</label> <input value="<%=c1.getName()%>"
							type="text" class="form-control" name="name">
					</fieldset>
					<fieldset class="form-group">
						<label>Account Number</label> <input
							value="<%=c1.getAccount_number()%>" id="accountnumber"
							type="text" class="form-control" name="accountnumber"
							readonly="readonly">
					</fieldset>

					<fieldset class="form-group">
						<label>NIC</label> <input value="<%=c1.getNic()%>" type="text"
							class="form-control" name="nic">
					</fieldset>

					<fieldset class="form-group">
						<label>Email</label> <input value="<%=c1.getEmail()%>" type="text"
							class="form-control" name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input value="<%=c1.getAddress()%>"
							type="text" class="form-control" name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Phone Number</label> <input
							value="0<%=c1.getPhonenumber()%>" type="number"
							class="form-control" name="phonenumber">
					</fieldset>

					<fieldset class="form-group">
						<label>Account Balance</label> <input
							value="<%=c1.getAccount_balance()%>" type="number"
							class="form-control" name="accountbalance">
					</fieldset>

					<fieldset class="form-group">
						<label>Account Status</label> <input value="<%=c1.isStatus()%>"
							style="width: 20px; height: 20px; margin-top: 20px;"
							type="checkbox" name="status">
					</fieldset>

					<fieldset class="form-group">
						<input id="password" value="<%=c1.getPassword()%>" name="password"
							type="hidden">
					</fieldset>

					<span style="color: red;">${error}</span>
					<fieldset class="form-group" style="text-align: center;">
						<input type="hidden" name="id" value="<%=c1.getAccount_number()%>" />
						<button type="submit" class="btn btn-warning">Update</button>
					</fieldset>
				</form>
				<div style="text-align: center;">
					<form id="contact" method="POST" action="DeleteCustomer">
						<fieldset>
							<input type="hidden" name="acno"
								value="<%=c1.getAccount_number()%>" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</fieldset>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
