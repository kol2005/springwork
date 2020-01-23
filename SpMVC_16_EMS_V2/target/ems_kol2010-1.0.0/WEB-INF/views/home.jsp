<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY EMS</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${rootPath}/css/main.css?ver=2020-01-20">
<link rel="stylesheet" type="text/css" href="${rootPath}/css/table-list.css?ver=2020-01-20">
<link rel="stylesheet" type="text/css" href="${rootPath}/css/email-write.css?ver=2020-01-20">

</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<c:choose>
<c:when test="${BODY == 'WRITE'}">
<%@ include file="/WEB-INF/views/body/ems/write.jsp" %>
</c:when>
<c:when test="${BODY == 'VIEW'}">
<%@ include file="/WEB-INF/views/body/ems/view-div.jsp" %>
</c:when>

<c:otherwise>
<%@ include file="/WEB-INF/views/body/ems/list.jsp" %>
</c:otherwise>
</c:choose>

<style>
div.login-modal{
display: none;
position: fixed;
top: 0;
left: 0;
width: 100%;
height: 100%;
background-color: rgba(0,0,0,0.4);
}
div.login-modal form{
position: relative;
top: 200px;
margin: 10px auto;
}
</style>

<div class="login-modal">
	<%@ include file="/WEB-INF/views/login.jsp" %>
</div>

</body>
</html>