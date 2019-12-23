<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/login.css?ver=2019-12-03">
</head>
<body>
<form method="POST" action="${rootPath}/member/login" class="login-form">
<h2>로그인</h2>
<c:if test="${LOGIN_MSG == 'FAIL'}">
<h3>ID or 비밀번호가 잘못되었습니다.</h3>
</c:if>
<c:if test="${LOGIN_MSG == 'TRY'}">
<h3>로그인을 해야합니다.</h3>
</c:if>
<c:if test="${LOGIN_MSG == 'NO_AUTH'}">
<h3>작성자만이 볼 수 있음!!</h3>
</c:if>
<c:if test="${LOGIN_MSG == '0'}">
<h3>로그인을 환영합니다.</h3>
</c:if>

<input type="text" name="u_id" placeholder="사용자 ID">
<input type="password" name="u_password" placeholder="비밀번호">
<button>로그인</button>
<c:if test="${LOGIN_MSG == '0'}">
<button>회원가입</button>
</c:if>
</form>


</body>
</html>