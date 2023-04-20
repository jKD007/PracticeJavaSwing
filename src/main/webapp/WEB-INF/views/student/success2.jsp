<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LAB2</title>
</head>
<body>
	<h1>THÔNG TIN SINH VIÊN PTITHCM</h1>
	<form:form action="/PTITHCMS1L1/student.htm" modelAttribute="student">
	<ul>
		<li>HỌ VÀ TÊN: ${student.name }</li>
		<li>ĐIỂM TRUNG BÌNH: ${student.mark }</li>
		<li>CHUYÊN NGÀNH: ${student.major }</li>
	</ul>
	</form:form>
</body>
</html>