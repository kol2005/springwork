<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>친구정보 자세히보기</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Popper JS -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<script>
$(function(){
	$("#f-list").click(function(){
		document.location.href = '${rootPath}/friend/list'
	})
	$("#f-update").click(function(){
		let f_id = $(this).attr("data-id")
		document.location.href = '${rootPath}/friend/update?f_id=' + f_id
	})
	$("#f-delete").click(function(){
		let f_id = $(this).attr("data-id")
		document.location.href = '${rootPath}/friend/delete/' + f_id
	})
	
})
</script>

<style>
th{
font-weight: bold;
font: 100;
}
</style>

</head>
<body>

	<div>
	<table>
		<tr><th>이름</th><td>${VIEW.f_name}</td></tr>
		<tr><th>전화번호</th><td>${VIEW.f_tel}</td></tr>
		<tr><th>주소</th><td>${VIEW.f_addr}</td></tr>
		<tr><th>취미</th><td>${VIEW.f_hobby}</td></tr>
		<tr><th>특기</th><td>${VIEW.f_relation}</td></tr>
	</table>
	</div>
	<button id="f-list" class="btn btn-success">친구정보 리스트</button>
	<button data-id="${VIEW.f_id}" id="f-update" class="btn btn-info">수정</button>
	<button data-id="${VIEW.f_id}" id="f-delete" class="btn btn-danger">삭제</button>
	
</body>
</html>