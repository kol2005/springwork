<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>

<style>

article{
display: flex;
flex-flow: wrap;
}

.book-title, .book-body{
display: inline-block;
width: 23%;
padding: 5px 16px;
margin: 5px;
background-color: #eee;
}

div.book-title{
background-color: #ccc;
text-align: right;
}


</style>
</head>
<body>

	
<section>
	<article>
		<div class="book-title">도서코드</div>
		<div class="book-body">${BOOK.b_code}</div>
		<div class="book-title">도서명</div>
		<div class="book-body">${BOOK.b_name}</div>
		<div class="book-title">출판사</div>
		<div class="book-body">${BOOK.b_comp}</div>
		<div class="book-title">저자</div>
		<div class="book-body">${BOOK.b_auther}</div>
		<div class="book-title">구입연도</div>
		<div class="book-body">${BOOK.b_year}</div>
		
		<div class="book-title">구입가격</div>
		<div class="book-body">
		<fmt:formatNumber value="${BOOK.b_iprice}" var="commaPrice" type="number" maxFractionDigits="3"/>${commaPrice}
		<fmt:formatNumber value="${BOOK.b_iprice}" var="currPrice" type="currency" maxFractionDigits="3"/>${currPrice}
		<fmt:setLocale value="en_us"/>
		<fmt:formatNumber value="${BOOK.b_iprice}" type="currency" maxFractionDigits="3"/>${currPrice}
		</div>
		
	</article>
</section>
	
</body>
</html>