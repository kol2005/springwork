<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home페이지</title>
</head>
<body>
<h1>나의 홈페이지</h1>

<P>서버에서 받은 시각 : ${serverTime}. </P>
<!-- anchor : 링크설정, 문자열을 클릭하면 다른 페이지로 점프 -->
<p>
<a href="list">학생리스트</a>
<a href="input">학생정보 입력</a>
<a href="search">학생정보 검색</a>
<a href="login">로그인</a>
<a href="join">회원가입</a>
</body>
</html>
