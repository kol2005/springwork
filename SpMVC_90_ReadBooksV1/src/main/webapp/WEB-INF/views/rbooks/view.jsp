<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리드북 인포</title>
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
	
	$("#btn-update").click(function(){
		let rb_seq = $(this).attr("data-id")
		document.location.href = "${rootPath}/rbook/update/" + rb_seq
	})
	$("#btn-delete").click(function(){
		let rb_seq = $(this).attr("data-id")
		document.location.href = "${rootPath}/rbook/delete/" + rb_seq
	})
	$("#btn-list").click(function(){
		document.location.href = "${rootPath}/rbook/list"
	})
	
})
</script>
</head>

<style>
header{
justify-content: center;
}
h1{
text-align:center;
color: blue;
}
article #rbook-view{
justify-content: center;
text-align:center;

}
</style>

<header>
<h1>도서기록</h1>
</header>
<body>
<section>
<article class="rbook-view">

<div class="rbook-view">
	<div class="rbook-box">책이름</div>
	<div>${RBOOK.rb_bname}</div>
</div>

<div class="rbook-view">
	<div class="rbook-box">읽은 시각</div>
	<div>${RBOOK.rb_date},${RBOOK.rb_stime}부터 ${RBOOK.rb_rtime} 시간까지 읽음</div>
</div>

<div class="rbook-view">	
	<div class="rbook-box">한줄평</div>
	<div>${RBOOK.rb_subject}
</div>

	<span class="star-box">
	<span class="star-red">
	
	</span></span>
	</div>
	<div class="text-box">${RBOOK.rb_text}</div>
	
</article>
<article>
<button data-id="${RBOOK.rb_seq}" id="btn-update" type="button" class="flex-right biz-blue btn-success">수정</button>
<button data-id="${RBOOK.rb_seq}" id="btn-delete" type="button" class="biz-red btn-danger">삭제</button>
<button data-id="${RBOOK.rb_seq}" id="btn-list" type="button" class="biz-orange btn-primary">리스트</button>
</article>
</section>
</body>
</html>