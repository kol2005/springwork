<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북 업데이트</title>
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
	
	$("#btn_book_update").click(function(){
		document.location.href = "${rootPath}/books/update"
	})
	
	$("#btn_book_delete").click(function(){
		document.location.href = "${rootPath}/books/delete"
	})
	
})
</script>

<style>

.in-box{
width: 300px;
padding: 4px;
background-color: #dedede;
}



fieldset{
/*
position: relative;
border-top: 10px;
*/
	margin-top: 50px;
	border: 2px solid black;
	text-align: center;
}



</style>

</head>
<body>
<div class="container">
<br/>
	<fieldset>
	<legend>북 업데이트</legend>
	<form:form modelAttribute="booksVO" class="books-form">
	<form:input path="b_code"  class="in-box" placeholder="ISBN"/><br/>
	<form:input path="b_name" class="in-box" placeholder="책 이름"/><br/>
	<form:input path="b_auther" class="in-box" placeholder="저자"/><br/>
	<form:input path="b_comp" class="in-box" placeholder="출판사"/><br/>
	<form:input path="b_year" class="in-box" placeholder="구입일자"/><br/>
	<form:input path="b_iprice" class="in-box" placeholder="구입가격"/><br/>
	<button id="btn_book_update" class="btn btn-success">저장</button>

	</form:form>

	
	<form:form modelAttribute="booksVO" class="books-form" action="${rootPath}/books/delete">

		<button id="btn_book_delete" name="btn_book_delete" class="btn btn-danger">삭제</button>
			<form:input path="b_code"  type="hidden"/><br/>
	</form:form>
		</fieldset>
</div>
</body>
</html>