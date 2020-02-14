<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리드북 업데이트</title>
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
	// 저장 버튼을 누르면 컨트롤러의 POST method로 이동
	$("#btn_book_update").click(function(){
		document.location.href = "${rootPath}/rbook/update"
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

	<h3>리드북 업데이트</h3>
	<form:form modelAttribute="rBookVO" class="books-form container p-3 my-3 border">
	
	<form:input path="rb_bcode" readonly="true" class="in-box" placeholder="ISBN"/><br/><br>
	<form:input path="rb_bname" readonly="true" class="in-box" placeholder="책 이름"/><br/>
	<form:input path="rb_date" class="in-box" placeholder="날짜"/><br/>
	<form:input path="rb_stime" class="in-box" placeholder="s타임"/><br/>
	<form:input path="rb_rtime" class="in-box" placeholder="r타임"/><br/>
	<form:input path="rb_subject" class="in-box" placeholder="한줄평"/><br/>
	<form:input path="rb_text" class="in-box" placeholder="내용"/><br/>
	<form:input path="rb_star" class="in-box" placeholder="별점"/><br/>
	<br>
	<button id="btn_rbook_update" class="bz-button btn btn-success">저장</button>

	</form:form>
	

</body>
</html>