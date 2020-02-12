<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이년</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script src="${rootPath}/js/summernote-ko-kr.min.js"></script>

<Style>
.card-header{
white-space: nowrap;
overflow: hidden;
text-overflow: ellipsis;
}
</Style>

</head>
<header class="jumbotron text-conter">
	<h3>네이버 영화 랭크</h3>
</header>

<body class="container-fluide">
<section class="row">
<c:forEach var="NAVER" items="${NAVER_LIST}">
	<%@ include file="/WEB-INF/views/naver-list-body.jsp" %>
</c:forEach>
</section>

</body>
</html>