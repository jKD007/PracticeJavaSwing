<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>${message}</div>
<form:form action="insert.htm" modelAttribute="record">
	<div>
		<label>Nhân viên</label>
		<form:select path="staff.id" items="${staffs}" itemValue="id" itemLabel="name"/>
	</div>
	<div>
		<label>Loại</label>
		<form:radiobutton path="type" value="true" label="Thành tích"/>
		<form:radiobutton path="type" value="false" label="Kỷ Luật"/>
	</div>
	<div>
		<label>Lý do</label>
		<form:textarea path="reason" row="3"/>
	</div>
	<div>
		<button>Insert</button>
	</div>
</form:form>
</body>
</html>