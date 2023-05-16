<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login App</title>
<style><%@include file="/static/style.css"%></style>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/script.js"></script> --%>
<script type="text/javascript"><%@include file="static/script.js" %></script>
</head>
<body>
  <div class="wrapper">
    <form action="login" method="post" id="loginForm">
      <div class="title">Login</div>
      <div class="alert">Please Enter valid username</div>
      <div class="container">
        <label for="uname">Username</label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label for="psw">Password</label>
        <input type="password" placeholder="Enter Password" name="password" required>

       <!--  <button type="submit" class="btn" onclick="authenticate(event)">Login</button>  -->    
        <button type="submit" class="btn" >Login</button>       
      </div>
    </form>
  </div>
<script type="text/javascript"><%@include file="static/script.js" %></script>
</body>
</html>