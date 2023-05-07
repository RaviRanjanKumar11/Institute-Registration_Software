<%@ page language="java" 
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body bgcolor=green text=black>
 <%
UserBean ub=(UserBean)session.getAttribute("ubean");
out.println("welcome user:"+ub.getfName()+"<br>");
%>
<a href="view">ViewPatient</a><br>
<a href="logout">logout</a>
 </body>
</html>