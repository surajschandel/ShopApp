<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<html>
<head>
<title>Login Page</title>
</head>
<center>
<h2>Hello, please log in:</h2>
<br>
<br>
<form action="/ShopApp-Web/login" method=post>
	<p>
		<strong>Please Enter Your User Name: </strong> <input type="text"	name="email" size="25">
	<p>
	<p>
		<strong>Please Enter Your Password: </strong> <input type="password" size="15" name="password">
	<p>
	<p><input type="submit" value="Submit"> <input type="reset"	value="Reset">
	<p>${message}</p>
</form>
</center>
</html>
