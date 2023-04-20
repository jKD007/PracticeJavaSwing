<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<div>${message}</div>
	<form action="insert">
		<table>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Fullname</th>
				<th></th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.fullname}</td>
					<td><a href="update/${user.username}.htm">Update</a></td>
					<td><a href="delete/${user.username}.htm">Delete</a></td>
					<%-- <td><a href="user/update.htm?username=${user.username}">Update</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.servletContext.contextPath}/user/insert.htm">Insert</a>
	</form>
</body>
</html>