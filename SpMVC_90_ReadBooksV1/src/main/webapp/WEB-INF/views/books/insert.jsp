<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북인서트</title>
<script>
$(function(){
	
	$("#btn_book_insert").click(function(){
		document.location.href = "${rootPath}/books/insert"
	})
	
})
</script>
</head>
<body>

	<fieldset>
	<legend>북인서트</legend>
	<form:form modelAttribute="booksVO" class="books-form">
	
	<form:input path="b_code"  class="in-box" placeholder="ISBN"/><br/>
	<form:input path="b_name" class="in-box" placeholder="책 이름"/><br/>
	<form:input path="b_auther" class="in-box" placeholder="저자"/><br/>
	<form:input path="b_comp" class="in-box" placeholder="출판사"/><br/>
	<form:input path="b_year" class="in-box" placeholder="구입일자"/><br/>
	<form:input path="b_iprice" class="in-box" placeholder="구입가격"/><br/>
	<button>저장</button>
	</form:form>
	</fieldset>

</body>
</html>