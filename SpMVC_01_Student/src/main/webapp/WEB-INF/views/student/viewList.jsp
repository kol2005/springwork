<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생리스트</h2>
<p> ${stdList[0].st_num} :
	${stdList[0].st_name} :
	${stdList[0].st_dept} :
	${stdList[0].st_grade} :
	${stdList[0].st_tel} :
	
<p> ${stdList[1].st_num} :
	${stdList[1].st_name} :
	${stdList[1].st_dept} :
	${stdList[1].st_grade} :
	${stdList[1].st_tel} :

<p> ${stdList[2].st_num} :
	${stdList[2].st_name} :
	${stdList[2].st_dept} :
	${stdList[2].st_grade} :
	${stdList[2].st_tel} :
		
</body>
</html>