<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나의 Spring Home</h3>
<p>서버시간:${serverTime}.</p>

<h3>학생정보</h3>
<p>이름 : ${st_name}</p>
<p>학과 : ${st_dept}</p>
<p>학년 : ${st_grade}</p>

<form action="my" method="POST">
<input name="strName">
<input name="strDept">
<button>전송</button>
</form>
</body>
</html>