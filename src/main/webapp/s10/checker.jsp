<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
</head>
<body>
    <h1>Hello!</h1>
    <p id="result">
        The user name
        <!--  quest è uno scriptlet e non viene più utilizzato -->
        <%
            @SuppressWarnings("unchecked")
            Set<Character> set = (Set<Character>) request.getAttribute("set");
            if (set == null || set.isEmpty()) {
                out.print("is empty");
            } else {
                out.print("contains these letters:");
        
                for (Character c : set) {
                    out.print(" " + c);
                }
            }
        %>
    </p>
    <%@include file="backHome.html"%>
</body>
</html>