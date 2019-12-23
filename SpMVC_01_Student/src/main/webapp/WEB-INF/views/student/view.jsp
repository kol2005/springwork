<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view 페이지</title>
</head>
<body>
<h2>학생정보 보기</h2>
<p>학번:${stDTO.st_num}</p>
<p>이름:${stDTO.st_name}</p>
<p>학과:${stDTO.st_dept}</p>
<p>학년:${stDTO.st_grade}</p>
<p>전화번호:${stDTO.st_tel}</p>
</body>
</html>