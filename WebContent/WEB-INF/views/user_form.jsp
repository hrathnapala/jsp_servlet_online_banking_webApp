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

				<form method="post" action="AddUserServlet">
					<fieldset class="form-group">
						<label>User Name</label> <input type="text"
							value="<c:out value='${user.name}' />" class="form-control"
							name="name" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>User Email</label> <input type="text"
							value="<c:out value='${user.email}' />" class="form-control"
							name="email">
					</fieldset>

					<fieldset class="form-group">
						<label>User Country</label> <input type="text"
							value="<c:out value='${user.country}' />" class="form-control"
							name="country">
					</fieldset>

					<button type="submit" class="btn btn-warning">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
