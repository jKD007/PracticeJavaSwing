<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>N19DCAT015</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>

	<form action="student/update.htm" method="post">
		<div>Họ và tên</div>
		<input name="name" value="${student.name }"/>
		<br>
		<div>Điểm trung bình</div>
		<input name="mark" value="${student.mark }"/>
		
		<div>Chuyên ngành</div>
		<label>
			<input name="major" type="radio" value="APP" 
				${student.major=='APP'?'checked':''}/>
			Ứng dụng phần mềm
		</label>
		<label>
			<input name="major" type="radio" value="WEB" 
				${student.major=='WEB'?'checked':''}/>
			Thiết kế trang web
		</label>
		<hr>

		<button>Cập nhật</button>
	</form>
</body>
</html>