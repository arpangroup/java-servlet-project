<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%! int NUMBER=9; %>  
<!DOCTYPE html>
<html>
<head>
<title>Today's Date And Time</title>
</head>
<body>
	<div style="font-size: 24px">
		Multiplication Table of <%=NUMBER %> is :
		<%
			for(int i = 1; i <= 10; i++) {
		%>
				<table>
					<tr>
						<td><%=NUMBER %> x <%=i %> = <%=NUMBER*i %></td>
					</tr>
				</table>
		<%
			}
		%>
</body>
</html>