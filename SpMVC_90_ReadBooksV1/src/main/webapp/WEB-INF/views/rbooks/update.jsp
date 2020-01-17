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
<script>
$(function(){
	
	$("#btn_book_update").click(function(){
		document.location.href = "${rootPath}/rbook/update"
	})
	
	
})
</script>
</head>
<body>

	<fieldset>
	<legend>리드북 업데이트</legend>
	<form:form modelAttribute="rBookVO" class="books-form">

	<form:input path="rb_bcode"  class="in-box" placeholder="ISBN"/><br/>
	<form:input path="rb_bname" class="in-box" placeholder="책 이름"/><br/>
	<form:input path="rb_date" class="in-box" placeholder="날짜"/><br/>
	<form:input path="rb_stime" class="in-box" placeholder="s타임"/><br/>
	<form:input path="rb_rtime" class="in-box" placeholder="r타임"/><br/>
	<form:input path="rb_subject" class="in-box" placeholder="한줄평"/><br/>
	<form:input path="rb_text" class="in-box" placeholder="내용"/><br/>
	<form:input path="rb_star" class="in-box" placeholder="별점"/><br/>
	<button id="btn_rbook_update">저장</button>

	</form:form>
	</fieldset>
	

</body>
</html>