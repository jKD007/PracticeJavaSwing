<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>report</title>
</head>
<body>
	<form action="">
		<table class="table table-hover">
			<tr>
				<th>Mã NV</th>
				<th>Tổng thành tích</th>
				<th>Tổng kỷ luật</th>
				<th>Tổng kết</th>
			</tr>
			<c:forEach var="a" items="${staffs}">
				<tr>
					<td>${a[0]}</td>
					<td>${a[1] }</td>
					<td>${a[2] }</td>
					<td>${a[1]*a[2]}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>