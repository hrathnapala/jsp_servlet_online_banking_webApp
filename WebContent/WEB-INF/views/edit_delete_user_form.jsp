<%@page import="com.obs.model.UserModel"%>
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
				UserModel c1 = (UserModel) request.getAttribute("um");
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
						<label>User Name</label> <input type="text"
							value="<%=c1.getName()%>" class="form-control" name="name"
							required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>User Email</label> <input type="text"
							value="<%=c1.getEmail()%>" class="form-control" name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>User Country</label> <input type="text"
							value="<%=c1.getCountry()%>" class="form-control" name="country">
					</fieldset>
					<span style="color: red;">${error}</span>
					<fieldset class="form-group" style="text-align: center;">
						<input type="hidden" name="id" value="<%=c1.getId()%>" />
						<button type="submit" class="btn btn-warning">Update</button>
					</fieldset>
				</form>
				<div style="text-align: center;">
					<form id="contact" method="POST" action="DeleteUserServlet">
						<fieldset>
							<input type="hidden" name="id" value="<%=c1.getId()%>" />
							<button type="submit" class="btn btn-danger">Delete</button>
						</fieldset>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
