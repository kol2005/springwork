<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>□□□나의 JSP 페이지□□□</title>
<style>
header{
background: #FA5882;
margin: 0;
padding: 1rem;
color: #00FF00;
}
header h3{
font-size: 2rem;
}
ol {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	background-color: #33ddff;
}

h3 {
	color: #000000;
}

ol a {
	display: block;
	text-decoration: none;
	padding: 14px 16px;
}

ol a:hover {
	background-color: #ddd;
	color: blue;
	border-bottom: 3px solid blue;
}

</style>
</head>
<body>
	<header>
		<h3>개돼지 관리</h3>
	</header>
	<!-- ul : unorderd List 약자 : 순서가 없는 List, 머릿글이 기호 -->
	<!-- ol : orderd List : 순서가 있는 List -->
	<ol>
		<!-- list item -->
		<li><a href="${rootPath}/student/list">개돼지리스트</a></li>
		<li><a href="${rootPath}/student/search">개돼지검색</a></li>
		<li><a href="#">로그인</a></li>
		<li><a href="#">개돼지가입</a></li>
	</ol>
	<img src="${rootPath}/resources/img/maxresdefault (1).jpg">
</body>
</html>