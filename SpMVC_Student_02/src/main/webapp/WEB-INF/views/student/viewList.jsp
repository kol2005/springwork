<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생리스트</h2>
<!-- jstl, core taglib를 사용한 tag 코드를 시작한다 c: -->
<!-- forEach, java의 확장 for(DTO : List와 같은 역할 -->
<c:forEach items="${stdList}" var="dto">
	<p>${dto.st_num} :
	${dto.st_name} :
	${dto.st_dept} :
	${dto.st_grade} :
	${dto.st_tel}
</c:forEach>
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