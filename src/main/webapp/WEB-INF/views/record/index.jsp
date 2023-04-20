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
				<th>Mã ID</th>
				<th>Loại</th>
				<th>Lí do</th>
				<th>Ngày</th>
				<th>Staff</th>
			</tr>
			<c:forEach var="record" items="${records}">
				<tr>
					<td>${record.id}</td>
					<td>${record.type?'thành tích':'kỹ luật'}</td>
					<td>${record.reason}</td>
					<td>${record.date}</td>
					<td>${record.staff.name}</td>
					<td><a href="update/${record.id}.htm">Update</a></td>
					<td><a href="delete/${record.id}.htm">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.servletContext.contextPath}/record/insert.htm">Insert</a>
	</form>
</body>
</html>