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
		$("form").submit()
	})
	
	$("#btn_book_delete").click(function(){
		let rb_seq = $(this).attr("data-id")
		document.location.href = "${rootPath}/books/delete?id="+ rb_seq
	})

})
</script>

<style>
h3{
padding: 20px;
border-top: 20px;
text-align: center;
}
.in-box{
width:700px;
border: center;
justify-content: center;
text-align: center;
font-size: 20px;
padding: 5px;
background-color: #66adff;
}
.books-form{
background-color: #d9d9d9;
text-align: center;
}
</style>

</head>
<body>

	<h3>북 업데이트</h3>
	
	<form:form modelAttribute="booksVO" action="${rootPath}/books/update" class="books-form container p-3 my-3 border">
	
	<form:input path="b_code" readonly="true" class="in-box" placeholder="ISBN"/><br/><br>
	<form:input path="b_name" class="in-box" placeholder="책 이름"/><br/>
	<form:input path="b_auther" class="in-box" placeholder="저자"/><br/>
	<form:input path="b_comp" class="in-box" placeholder="출판사"/><br/>
	<form:input path="b_year" class="in-box" placeholder="구입일자"/><br/>
	<form:input path="b_iprice" class="in-box" placeholder="구입가격"/><br/>
	<br>
	<button id="btn_book_update" data-id="${booksVO.b_code}" type="button" class="btn btn-success">저장</button>
	<button id="btn_book_delete" data-id="${booksVO.b_code}" type="button" class="btn btn-danger">삭제</button>

	</form:form>
	

	
</body>
</html>