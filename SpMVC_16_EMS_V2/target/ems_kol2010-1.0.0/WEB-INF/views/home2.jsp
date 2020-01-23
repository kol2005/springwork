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

<link rel="stylesheet" type="text/css" href="${rootPath}/resources/">

<script>
$(function(){
	$(".nav-link").click(function(){
		let href = $(this).attr("data-menu")
		document.location.href = "${rootPath}/" + href
	})
})
</script>
<style>
#head {
	background-color: red;
	text-align: center;
	padding: 20px;
}

.navbar-nav{
color: rgb(191, 6, 6);
background-color: rgb(181, 181, 181);
margin: 0;
}
.navbar-nav:hover{
font-size: bold;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/body/ems/list.jsp" %>

	<header>
		<h2 id="head">MY EMS</h2>
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<ul class="navbar-nav">
				<li class="nav-item active">
				<a class="nav-link" href="javascript:void(0)" data-menu="list">EMS</a>
				</li>
				
				<li class="nav-item">
				<a class="nav-link" href="javascript:void(0)" data-menu="bbs/free">자유게시판</a>
				</li>
				
				<li class="nav-item">
				<a class="nav-link" href="javascript:void(0)" data-menu="bbs/notice">공지사항</a>
				</li>
				
				<li class="nav-item">
				<a class="nav-link" href="javascript:void(0)" data-menu="member/login">로그인</a>
				<li class="nav-item">
				<a class="nav-link" href="javascript:void(0)" data-menu="member/join">회원가입</a>
				</li>
				
			</ul>
		</nav>
	</header>
	<table class="table">
		<thead>
			<tr>
				<th>NO</th>
				<th>받는 EMAIL</th>
				<th>받는 사람</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>작성시각</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>데이터가 없습니다</td>
			</tr>
		</tbody>
	</table>
	<button type="button" class="btn btn-link">메일보내기</button>

</body>
</html>