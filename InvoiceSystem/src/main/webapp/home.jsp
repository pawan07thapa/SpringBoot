<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Login</h2>
		<form action="cusLogin">
				<input type="text" name="cName"> Id<br> 
				<input type="password" name="cPassword"> Id<br> 
				<input type="submit"><br>
		</form>
		<hr>
		<hr>
		<hr>
		<hr>
		
		<h2>  Register</h2>
		<form action="addCustomer">
				<input type="text" name="cId"> Id<br> 
				<input type="text" name="cName">Name<br>
				<input type="text" name="cAge">Age<br>
				<input type="text" name="cPhoneNum">c<br>
				<input type="text" name="cAddress">Address<br>
				<input type="password" name="password">Password<br>
				<input type="submit"><br>
		</form>

	

</body>
</html>