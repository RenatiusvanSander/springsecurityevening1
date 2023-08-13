<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Login</title>
</head>
<body>
	<h1>My Custom login page</h1>
	<form:form action="process-login" method="POST">
		Username : <input type="text" name="username">
		<br />
		Password : <input type="password" name="password">
		<br />
		<input type="submit" value="Login">
	</form:form>
</body>
</html>