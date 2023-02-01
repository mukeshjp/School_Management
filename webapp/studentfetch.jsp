<%@page import="serveletprogram.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
font{
   background-color: green;
}
</style>
</head>
<body align="center" bgcolor="grey">
<% Student s =(Student)session.getAttribute("studentlist"); %>
<table cellpadding="10px" align="center" border="1" bgcolor="yellow">
<th> <font color="red">Id</font></th>
<th> <font color="red">Name</font></th>
<th> <font color="red">Stream</font></th>
<th> <font color="red">Fees</font></th>
<tr>
<td><%=s.getId() %></td>
<td><%=s.getName() %></td>
<td><%=s.getStream() %></td>
<td><%=s.getFees() %></td>
</tr> 
</table>
</body>
</html>