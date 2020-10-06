<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello4</title>
</head>
<body>
	<c:if test="${alreadyRegistered == false}">
		<p>First name is ${firstName}</p>
		<p>Last name is ${lastName}</p>
		<h1>Welcome ${firstName} ${lastName}! Hello, my friend!</h1>
	</c:if>
	<c:if test="${alreadyRegistered == true}">
		<p>First name is ${firstName}</p>
		<p>Last name is ${lastName}</p>
		<h1>Welcome ${firstName} ${lastName}! Hello, my friend!</h1>
	</c:if>
	 <form action="/mdwa/s17/logout.jsp">
            <button name="logout" value = "true">Logout</button>
            
     </form>
 <%@include file="../s10/backHome.html"%>
</body>
</html>
	 
