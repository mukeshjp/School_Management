<%@page import="serveletprogram.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="grey" align="center">
<%Teacher t = (Teacher)session.getAttribute("teacherlist"); %>
<table cellpadding="10px" align="center" border="1" bgcolor="yellow" bordercolor="black">
<th> <font color="red">id</font></th>
<th> <font color="red">name</font></th>
<th> <font color="red">salary</font></th>
<th> <font color="red">subject</font></th>
<tr>
<td><%=t.getId() %></td>
<td><%=t.getName() %></td>
<td><%=t.getSubject() %></td>
<td><%=t.getSal() %></td>
</tr>
</table>
</body>
</html> 