<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<title>SQL TEST</title>
</head>
<body>
  <sql:setDataSource 
  	var = "db" 
  	driver = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://localhost:3306"
    user = "root"  password = ""/>

   <sql:query dataSource = "${wipro_servlet}" var = "result">SELECT * from user;</sql:query>
</body>
</html>