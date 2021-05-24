<%@page import="com.obs.model.CustomerModel"%>
<%@page import="com.obs.model.EmployeeModel"%>
<%@page import="service.UserController"%>
<%@page import="com.obs.model.AdminModel"%>
<%@page import="java.util.ArrayList"%>
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
				<a href="#" class="navbar-brand "> Employee Dashboard </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="index.jsp" class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="customerForm" class="btn btn-success">Add New Customer</a>
			</div>
			<br>
			<table class="table table-bordered" style="color: white;">
				<thead>
					<tr>
						<th>Customer Name</th>
						<th>Account Number</th>
						<th>NIC</th>						
						<th>Email</th>
						<th>Address</th>
						<th>Phone Number</th>
						<th>Account Balance</th>
						<th>Account Status</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>
					<%
					UserController hs = new UserController();
								ArrayList<CustomerModel> al = hs.getCustomerList();

								for (CustomerModel e : al) {
					%>

					<tr>
						<td><%=e.getName()%></td>
						<td><%=e.getAccount_number()%></td>
						<td><%=e.getNic()%></td>
						<td><%=e.getEmail()%></td>
						<td><%=e.getAddress()%></td>
						<td>0<%=e.getPhonenumber()%></td>
						<td><%=e.getAccount_balance()%></td>
						<td><%=e.isStatus()%></td>
						<td
							style="display: flex; justify-content: center; align-items: center;">
							<form method="POST" action="GetCustomer">
								<input type="hidden" name="acno" value="<%=e.getAccount_number()%>" /> <input
									type="submit" value="EDIT/DELETE" class="btn-grad" />
							</form>

						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
