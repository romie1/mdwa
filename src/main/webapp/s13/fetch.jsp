<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello EL</title>
</head>
<body>
    <h1>Hello!</h1>

    <p>Document title: ${doc.title}</p>
    <p>Document user name: ${doc.user.name}</p>
    <p>Document title (in the request scope): ${requestScope.doc.title}</p>

    <p>Request parameter x: ${param.x}</p>
    <p>Header host name: ${header.host}</p>
    <p>
        Back <a href="/mdwa/index.html">home</a>
    </p>
</body>
</html>