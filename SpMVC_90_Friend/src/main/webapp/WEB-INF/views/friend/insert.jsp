<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구정보 입력</title>
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
	$("#btn-f-insert").click(function(){
		document.location.href = "${rootPath}/friend/insert"
	})
})
</script>
<style>
body{
justify-content: center;
}

in-box{
justify-content:center;
}

fieldset{
margin: 20%;
text-align:center;
width: 50%;
height: 50%;
display: flex;
padding: auto;
border: 2px black solid;
}

</style>
</head>
<body>
	
	<fieldset>
		<legend>친구정보 입력</legend>
		<form:form modelAttribute="fVO" class="f-form">
			<form:input path="f_id" class="in-box" type="hidden"/><br/>
			<form:input path="f_name" class="in-box" placeholder="이름"/><br/>
			<form:input path="f_tel" class="in-box" placeholder="전화번호"/><br/>
			<form:input path="f_addr" class="in-box" placeholder="주소"/><br/>
			<form:input path="f_hobby" class="in-box" placeholder="취미"/><br/>
			<form:input path="f_relation" class="in-box" placeholder="관계"/><br/>
			<button id="btn-f-insert" class="btn btn-primary">저장</button>
		</form:form>
	</fieldset>

</body>
</html>