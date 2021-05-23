<%@page import="com.obs.model.EmployeeModel"%>
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
	<div class="container col-md-5">
		<div class="card" style="background-color: #077058;">
			<div class="card-body">
				<%
				EmployeeModel c1 = (EmployeeModel) request.getAttribute("um");
				%>

				<%
				if (request.getAttribute("error") != null) {
				%>
				<div class="error">${error}</div>
				<%
				}
				%>
				<form method="post" action="EditUserServlet">
					<fieldset class="form-group">
						<label>Full Name</label> <input value="<%=c1.getName()%>" type="text" class="form-control"
							name="name">
					</fieldset>

					<fieldset class="form-group">
						<label>Email</label> <input value="<%=c1.getEmail()%>" type="text" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>NIC</label> <input value="<%=c1.getNic()%>" type="text" class="form-control"
							name="nic">
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input value="<%=c1.getAddress()%>" type="text" class="form-control"
							name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Phone Number</label> <input value="<%=c1.getPhonenumber()%>" type="text"
							class="form-control" name="phonenumber">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Password</label> <input value="<%=c1.getPassword()%>" type="text"
							class="form-control" name="password">
					</fieldset>

					<fieldset class="form-group">
						<label>Employee ID</label> <input value="<%=c1.getEid()%>" type="text"
							class="form-control" name="eid" readonly="readonly">
					</fieldset>
					<span style="color: red;">${error}</span>
					<fieldset class="form-group" style="text-align: center;">
						<input type="hidden" name="id" value="<%=c1.getEid()%>" />
						<button type="submit" class="btn btn-warning">Update</button>
					</fieldset>
				</form>
				<div style="text-align: center;">
					<form id="contact" method="POST" action="DeleteUserServlet">
						<fieldset>
							<input type="hidden" name="eid" value="<%=c1.getEid()%>" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</fieldset>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
