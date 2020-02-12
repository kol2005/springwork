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
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script>
$(function(){
	
	$("#btn_book_list").click(function(){
		document.location.href = "${rootPath}/books/list"
	})
	
	$("#btn_read_insert").click(function(){
		document.location.href = "${rootPath}/rbook/insert"
	})
	
	$("#rbook-list tbody tr").click(function(){
		let rb_seq = $(this).attr("data-id")
		document.location.href = "${rootPath}/rbook/rbookinfo/" + rb_seq
	})
	
})
</script>
<style>

header h1{
color: #297bff;
display: flex;
justify-content: center;
margin: 20px;
padding: 20px;
}

h1{
background-color: #ffdd57;
font-weight: bold;
}

th{
font-weight: bold;
}

</style>
</head>
<header>
<h1>도서정보</h1>
</header>
<body>
<div class="container">
	<table id="rbook-list" class="table table-bordered">
	<tr class="table-dark text-dark">
		<th>사용자 ID</th>
		<th>도서코드</th>
		<th>도서제목</th>
		<th>독서일자</th>
		<th>한줄소감</th>
		<th>별점</th>
	</tr>
	
	<tr>

	<c:if test="${!empty rbList}">
	
	<c:forEach items="${rbList}" var="rbook">
	<tbody>
		<tr data-id="${rbook.rb_seq}" class="table-active">
		<td>사용자ID</td>
		<td>${rbook.rb_bcode}</td>
		<td>${rbook.rb_bname}</td>
		<td>${rbook.rb_date}</td>
		<td>${rbook.rb_subject}</td>
		<td>${rbook.rb_star}</td>
		</tr>
	</tbody>
	</c:forEach>

	</c:if>

	</tr>
	
	</table>
</div>
	
	<section>
		<button id="btn_book_list" class="bz-button btn btn-primary">도서 리스트</button>
		<button id="btn_read_insert" class="bz-button btn btn-success">독서 리스트 작성</button>
	</section>

</body>
</html>