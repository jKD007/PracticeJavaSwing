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
	<form>
		<table>
			<tr>
				<th>Mã NV</th>
				<th>Họ và Tên</th>
				<th>Giới tính</th>
				<th>Phòng</th>
			</tr>
			<c:forEach var="s" items="${staffs}">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.gender?'Nam':'Nữ'}</td>
					<td>${s.depart.name}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>