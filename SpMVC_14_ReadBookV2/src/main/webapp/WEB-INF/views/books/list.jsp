<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<script>
$(function(){
	
	// $("#btn-write").click(function(){ })
	$("#btn-write").click(()=>{
		document.location.href="${rootPath}/book/write"
	})
})
</script>
</head>
<body>
	<header>
		<h2>MY READ BOOK</h2>
	</header>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section id="main-list">
		<table id="main-table">
			<thead>
				<tr>
					<th>도서코드</th>
					<th>도서이름</th>
					<th>출판사</th>
					<th>저자</th>
					<th>구입일자</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BLIST}" var="BOOK">
					<tr>
						<td>${BOOK.b_code}</td>
						<td>${BOOK.b_name}</td>
						<td>${BOOK.b_comp}</td>
						<td>${BOOK.b_auther}</td>
						<td>${BOOK.b_year}</td>
						<td>${BOOK.b_iprice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section>
		<div id="main-button">
			<button id="btn-writh" class="biz-blue flex-right">독서록 작성</button>
		</div>
	</section>
	
</body>
</html>