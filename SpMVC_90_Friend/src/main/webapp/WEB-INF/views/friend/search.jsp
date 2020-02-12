<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구정보 찾기</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Popper JS -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
$(function(){
	$("#btn-f-insert").click(function(){
		document.location.href = "${rootPath}/friend/update"
	})
})
</script>
</head>
<header>
<h1>친구정보 검색 결과</h1>
</header>

<body>

<div class="container">
	<table class="table">

		<thead>
			<tr class="table-success">
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>관계</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="s-list" items="${SEARCH}">
				<tr class="table-info" data-id="${s-list.f_id}">
					<td>${s-list.f_name}</td>
					<td>${s-list.f_tel}</td>
					<td>${s-list.f_addr}</td>
					<td>${s-list.f_hobby}</td>
					<td>${s-list.f_relation}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</div>
	
</body>
</html>