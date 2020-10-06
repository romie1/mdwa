<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<br>
	<br>
		<form action="/mdwa/s17/hello4">
			<input name="firstName" placeholder="first name"> <input
				name="lastName" placeholder="last name">
			<button>OK</button>
		</form>
	<br>
	<br>

	<c:if test="${alreadyRegistered == true}">
		<p>You have already registered!</p>
		<form action="/mdwa/s17/hello4">
			<button>OK</button>
		</form>
	</c:if>


</body>
</html>