<%@page import="com.obs.model.CustomerModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Dashboard</title>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	list-style: none;
	text-decoration: none;
	font-family: 'Poppins', sans-serif;
}

body {
	background-color: #f3f5f9;
}

.wrapper {
	display: flex;
	position: relative;
}

.wrapper .sidebar {
	width: 200px;
	height: 100%;
	background: #4b4276;
	padding: 30px 0px;
	position: fixed;
}

.wrapper .sidebar h2 {
	color: #fff;
	text-transform: uppercase;
	text-align: center;
	margin-bottom: 30px;
}

.wrapper .sidebar ul li {
	padding: 15px;
	border-bottom: 1px solid #bdb8d7;
	border-bottom: 1px solid rgba(0, 0, 0, 0.05);
	border-top: 1px solid rgba(255, 255, 255, 0.05);
}

.wrapper .sidebar ul li a {
	color: #bdb8d7;
	display: block;
}

.wrapper .sidebar ul li a .fas {
	width: 25px;
}

.wrapper .sidebar ul li:hover {
	background-color: #594f8d;
}

.wrapper .sidebar ul li:hover a {
	color: #fff;
}

.wrapper .sidebar .social_media {
	position: absolute;
	bottom: 0;
	left: 50%;
	transform: translateX(-50%);
	display: flex;
	margin-bottom: 10px;
}

.wrapper .sidebar .social_media a {
	display: block;
	width: 40px;
	background: #594f8d;
	height: 40px;
	line-height: 45px;
	text-align: center;
	margin: 0 5px;
	color: #bdb8d7;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.wrapper .main_content {
	width: 100%;
	margin-left: 200px;
}

.wrapper .main_content .header {
	padding: 20px;
	background: #fff;
	color: #717171;
	border-bottom: 1px solid #e0e4e8;
}

.wrapper .main_content .info {
	margin: 20px;
	color: #717171;
	line-height: 25px;
}

.wrapper .main_content .info div {
	margin-bottom: 20px;
}

.balance {
	width: 500px;
	padding: 40px;
	position: relative;
	top: 100%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #191919;
	text-align: center;
	border-radius: 15px;
	color: white;
	height: 200px;
}

.box {
	width: 500px;
	padding: 40px;
	position: absolute;
	top: 600%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #191919;
	text-align: center;
	border-radius: 15px;
}

.box h1 {
	color: white;
	text-transform: uppercase;
	font-weight: 500;
}

.box input[type="text"], .box input[type="password"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
}

.box input[type="text"]:focus, .box input[type="password"]:focus {
	width: 280px;
	border-color: #2ecc71;
}

.box input[type="submit"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #2ecc71;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.box input[type="submit"]:hover {
	background: #2ecc71;
}
</style>

<script type="text/javascript">
	
	function validate() {
		var acno1 = document.transfermoney.acno1.value;
		var amount = document.transfermoney.amount.value;
		var accountbalance = document.transfermoney.accountbalance.value;
		
		
		if (acno1 == '') {
			alert("Please Enter Account Number");
			document.CustomerForm.focus();
			return false;
		} else if (amount == '') {
			alert("Please Enter Amount");
			document.CustomerForm.focus();
			return false;
		} else if (Number(accountbalance) - Number(amount) < 1){
			alert("Insufficient Balance");
			document.CustomerForm.focus();
			return false;
		}
		document.forms['transfermoney'].submit();
	}
</script>
</head>
<body>

	<%
	CustomerModel c1 = (CustomerModel) request.getAttribute("cm");
	%>
<div class="wrapper">
		<div class="sidebar">
			<h2>Dashboard</h2><br> <br>
			
			<div style="text-align: center;">
				<form id="contact" method="POST" action="CustomerDashBoard">
					<fieldset>
						<input type="hidden" name="acno"
							value="<%=c1.getAccount_number()%>" />
						<button type="submit" style="width: 80%;" type="button" class="btn btn-primary">Home</button>
					</fieldset>
				</form>
			</div> <br> <br>
			<div style="text-align: center;">
				<form id="contact" method="POST" action="CustomerAccountBalance">
					<fieldset>
						<input type="hidden" name="acno"
							value="<%=c1.getAccount_number()%>" />
						<button type="submit" style="width: 80%;" type="button" class="btn btn-success">Account Balance</button>
					</fieldset>
				</form>
			</div><br> <br>
			<div style="text-align: center;">
				<form id="contact" method="POST" action="TransferMoneyDashboard">
					<fieldset>
						<input type="hidden" name="acno"
							value="<%=c1.getAccount_number()%>" />
						<button type="submit" style="width: 80%;" type="button" class="btn btn-info">Transfer Money</button>
					</fieldset>
				</form>
			</div>
			<br> <br>
			<div style="text-align: center;">
				<form id="contact" method="POST" action="#">
					<fieldset>
						<input type="hidden" name="acno"
							value="<%=c1.getAccount_number()%>" />
					<a  href="index.jsp"><button style="width: 80%;" type="button" class="btn btn-warning">Logout</button></a>	
					</fieldset>
				</form>
			</div>
		</div>


		<div class="main_content">
			<div class="header">
				Welcome
				<%=c1.getName()%>
				&nbsp;&nbsp;&nbsp;&nbsp; Account Number:
				<%=c1.getAccount_number()%></div>
		</div>
		<form name="transfermoney" class="box" action="TransferMoney"
			method="post" onsubmit="event.preventDefault(); validate();">
			<h1>Money Transfer</h1>
			<input type="text" name="acno" value="<%=c1.getAccount_number()%>"
				readonly="readonly"> <input type="text"
				name="accountbalance" value="<%=c1.getAccount_balance()%>"
				readonly="readonly"> <input type="text" name="acno1"
				placeholder="Account Number"> <input type="text"
				name="amount" placeholder="Transfer Amount"> <span
				style="color: red;">${error}</span> <input type="submit" name=""
				value="Transfer Money">
		</form>
	</div>

</body>
</html>