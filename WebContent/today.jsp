<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Today's Date And Time</title>
<style><%@include file="/static/style.css"%></style>
</head>
<body>
	<div class="error_container">
		<%
         Date date = new Date();
         out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
      	%>
	</div>
</body>
</html>