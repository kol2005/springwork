<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
$(function(){
	$("#search-table tr").click(function(){
		let trs = $(this).children()
		let b_code = trs.eq(0).text()
		let b_name = trs.eq(1).text()
		
		$("#rb_bcode").val(b_code)
		$("#rb_bname").val(b_name)
		
		$("#modal-box").css("display","none")
	})
})
</script>
</head>
<body>
	<section id="search-list">
		<table id="search-table">
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

	</section>
	
</body>
</html>