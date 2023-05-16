<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Training | DELETE</title>
<style><%@include file="/static/style.css"%></style>
</head>
<body>
  <div class="wrapper">
    <form action="deleteTraining" method="post">
      <div class="container">
        <label>Delete Training</label>
        
        <select id="trainingOptions" name="trainingOptions" required>
        <option value="">Please Select...</option>		  
		   <c:forEach items="${trainings}" var="training">
		  		<option value="${training.trainingName}">${training.trainingName}</option>
		    </c:forEach>
		</select>
        <input type="submit" class="btn" value="Delete Training"/>       
      </div>
    </form>
  </div>
</body>
</html>