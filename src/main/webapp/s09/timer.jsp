<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>
    	<!--  unico elemento di dinamicità-->
        <%
            out.print(LocalTime.now());
        %>
    </h1>
    <p>
        Back <a href="/mdwa/index.html">home</a>
    </p>
</body>
</html>