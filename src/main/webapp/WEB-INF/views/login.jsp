<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!! (from jsp)</title>
</head>
<body>
My First JSP!!! 

<p>current date is <%= date %></p>
<p style="color: red;">${errorMessage}</p>
<form action="/spring-mvc/login.do" method="post">
Enter your name <br>
<input type="text" name="name"/> <br>
Enter your password <br>
<input type="password" name="password" />
<input type="submit">
</form>
</body>
</html>