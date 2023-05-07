<%@ page language="java" 
contentType="text/html;
 charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.AdminBean"
    %>
<!DOCTYPE html>
<html>
<head>
</head>
<body bgcolor=green text=black>

<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("welcome admin:"+ab.getFName()+"<br>");
%>
<a href="view">ViewProducts</a>
<a href="product.html">AddProduct</a>
<a href="logout">logout</a>

</body>
</html>