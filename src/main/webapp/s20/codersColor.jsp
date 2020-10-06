<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coders</title>
</head>
<body>
    <h1>Coders</h1>
    <table>
         <tr>
        	<th>color</th>
            <th>id</th>
            <th>first name</th>
            <th>last name</th>
            <th>hire date</th>
            <th>salary</th>
        </tr>
        <c:forEach var="cur" items="${codersColor}">
            <tr>
            	<td style="color:${cur.color}">${cur.color}</td>
                <td>${cur.id}</td>
                <td>${cur.firstName}</td>
                <td>${cur.lastName}</td>
                <td>${cur.hireDate}</td>
                <td>${cur.salary}</td>
            </tr>
        </c:forEach>
    </table>

  <%@include file="../s10/backHome.html"%>
</body>
</html>