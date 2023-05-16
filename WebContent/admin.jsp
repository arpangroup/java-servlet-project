<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.List,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Portal</title>
<style><%@include file="/static/style.css"%></style>
</head>
<body>
  <div class="wrapper">
    <div class="title">Wlcome To Admin Portal</div>
    <div id="training_action">
      <a class="btn" href="${pageContext.request.contextPath}/addTraining.jsp">Add Training</a>
      <a class="btn" href="${pageContext.request.contextPath}/GetDeleteTrainings">Delete Training</a>
    </div>
    <table>
      <tr>
        <th>TrainingId</th>
        <th>TrainingName</th>
        <th>StartDate</th>
        <th>EndDate</th>
        <th>TrainingMode</th>
        <th>BusinessUnit</th>
        <th>ContactPersonId</th>
      </tr>      
	   <c:forEach items="${trainings}" var="training">
	   		<tr>
		  		<td>${training.trainingId}</td>
		  		<td>${training.trainingName}</td>
		  		<td>${training.startDate}</td>
		  		<td>${training.endDate}</td>
		  		<td>${training.trainingMode}</td>
		  		<td>${training.businessUnit}</td>
		  		<td>${training.contactPersonId}</td>
	  		</tr>
	    </c:forEach>
    </table>
  </div>	
</body>
</html>