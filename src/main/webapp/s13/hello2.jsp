<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<c:if
		test="${registered == false && param.firstName == '' && param.lastName != ''}">
		<p>First name registered is null or wrong!</p>
		<p>Last name is ${param.lastName}</p>
		<h1>Retry!</h1>
	</c:if>
	<c:if
		test="${registered == false && param.firstName != '' && param.lastName == ''}">
		<p>First name is ${param.firstName}</p>
		<p>Last name registered is null or wrong!</p>
		<h1>Retry!</h1>
	</c:if>
	<c:if test="${registered == true}">
		<p>First name is ${param.firstName}</p>
		<p>Last name is ${param.lastName}</p>
		<h1>Welcome ${param.firstName} ${param.lastName}! Hello, my friend!</h1>
	</c:if>
	 <%@include file="/mdwa/s10/backHome.html"%>
	  <%@include file="/mdwa/src/main/webapp/s10/backHome.html"%>
	 
</body>
</html>