<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
</head>
<body>
<!-- 현재 이페이지를 열기 위한 
url : /context/param/update?code=10 
form에 action을 별도로 지정하지 않으면
action="/context/param/update?code=10" 라는 값으로
자동 지정
-->
<form method="POST">
	<label>코드</label><input name="code">
	<button>전송</button>
</form>
</body>
</html>