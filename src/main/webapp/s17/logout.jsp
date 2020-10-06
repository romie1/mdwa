<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log out</title>
</head>
<body>
	<br>
	<b>You're logged out! </b>

	<%
		session.invalidate();
		response.sendRedirect("helloRegistration.jsp");
	%>
	<%@include file="../s10/backHome.html"%>
</body>
</html>