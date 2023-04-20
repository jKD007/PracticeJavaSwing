<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8"/>
	<title>Spring MVC - Databinding </title>
	<base href ="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<h3> SINH VIÊN PTITHCM </h3>
	<form:form action="student/update.htm" modelAttribute ="student">
		<div> Họ và tên </div>
			<form:input path="name"/>
		<div> Điểm </div>
			<form:input path="mark"/>
		   <div> Chuyên ngành </div>
			<form:radiobutton path="major" value="APP"
		label ="Ứng dụng phần mềm"/>
			<form:radiobutton path="major" value="WEB"
		label ="Thiết kế trang web"/>
		<!-- <div>Chuyên ngành</div>
			<form:select path="major" items="${majors}"/>  -->
		
		<br> 
		<div>Chuyên ngành</div>
			<form:select path="major" items="${majors}"
		itemValue="id" itemLabel="name" />
		<br>
		<button> Cập nhật </button>
		
	</form:form>
</body>
</html>