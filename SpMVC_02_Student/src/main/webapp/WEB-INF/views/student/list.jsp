<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>□□□나의 JSP 페이지□□□</title>
</head>
<body>
	<h3>학생리스트</h3>
	<%
		/*
		Controller부터 List 데이터를 수신을 하면
		forEach 명령을 이용해서 List를 view에 구현한다
		
		<c:forEach>를 사용해서 구현을 한다
		items : controller에서 받은 List의 Attribute(변수)이름
		var : items 리스트의 요소를 하나씩 저장해 받을 dto 이름
		*/
	%>
	<c:forEach items="${STD_LIST}" var="std" varStatus="itemNum">
		<p>${itemNum.count},${itemNum.index} : ${std}</p>
	</c:forEach>
</body>
</html>