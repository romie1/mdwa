<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Attribute in application scope</title>
</head>
<body>
    <h1>The web app started at ${applicationScope.start}</h1>
    <p>
        Back <a href="/mdwa/index.html">home</a>
    </p>
</body>
</html>