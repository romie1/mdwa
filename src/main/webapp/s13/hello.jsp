<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<br>
	<br>
	<h1>Welcome ${param.firstName} ${param.lastName}! Hello, my friend!</h1>

	<%@include file="/backHome1.html"%>	

</body>
</html>