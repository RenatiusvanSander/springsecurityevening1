<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<h1>Signup page</h1>
	<form:form action="process-signup" method="POST" modelAttribute="signupdto">
		Username : <form:input path="username"/>
		<br />
		Password : <form:password path="password"/>
		<br />
		Repeat password : <form:password path="repeatedPassword"/>
		<br />
		E-Mail: <form:input path="email"/>
		<br />
		repeat E-Mail: <form:input path="repeatedEmail"/>
		<br />
		<input type="submit" value="signup">
	</form:form>
</body>
</html>