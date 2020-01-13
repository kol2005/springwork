<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script src="${rootPath}/javascript/summernote-ko-KR.js"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<script>
$(function(){
	
	$("#btn_book_list").click(function(){
		document.location.href = "${rootPath}/books/list"
	})
	
})
</script>
</head>
<header>
<h1>도서정보</h1>
</header>
<body>
	<table>
	<tr>
		<td>사용자 ID</td>
		<td>도서코드</td>
		<td>도서제목</td>
		<td>독서일자</td>
		<td>한줄소감</td>
		<td>별점</td>
	</tr>
	
	<tr>
	<td>
	<c:if test="${!empty rbList}">
	<c:forEach items="${bookList}" var="books">
	<c:forEach items="${mList}" var="member">
	<c:forEach items="${rbList}" var="rbook">
		<td>${member.m_id}</td>
		<td>${books.b_code}</td>
		<td>${books.b_name}</td>
		<td>${rbook.rb_date}</td>
		<td>${rbook.rb_subject}</td>
		<td>${rbook.rb_star}</td>
	</c:forEach>
	</c:forEach>
	</c:forEach>
	</c:if>
	</td>
	</tr>
	
	</table>
	
	<section>
		<button id="btn_book_list" class="bz-button">도서 리스트</button>
		<button id="btn_member_list" class="bz-button">독서 리스트</button>
	</section>

</body>
</html>