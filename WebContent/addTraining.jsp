<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Training | ADD</title>
<style><%@include file="/static/style.css"%></style>
</head>
<body>
  <div class="wrapper">
    <form action="addTraining" method="post">
      <div class="container">
        <label>Enter Training Name</label>
        <input type="text" placeholder="Enter Training Name" name="trainingName" required>
        <label>Start Date</label>
        <input type="date" placeholder="Start Date" name="startDate">
        <label>End Date</label>
        <input type="date" placeholder="End Date" name="endDate">
        <label>Enter Training Mode</label>
        <input type="text" placeholder="Enter Training Mode" name="trainingMode">
        <label>Enter Business Unit</label>
        <input type="text" placeholder="Enter Business Unit" name="businessUnit">
        <label>Enter Contact Person Id</label>
        <input type="text" placeholder="Enter Contact Person Id" name="contactPersonId">

        <input type="submit" class="btn" value="Add New Training"/>       
      </div>
    </form>
  </div>
</body>
</html>