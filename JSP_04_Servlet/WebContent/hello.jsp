<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String st_name = request.getParameter("st_name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/JSP_04_Servlet/hello">
	<label>이름 : </label><input name="st_name">
	<label>학과 : </label><input name="st_dept">
	<label>학년 : </label><input name="st_grade">
			<button>서버로 전송</button>
	</form>
	
	
</body>
</html>