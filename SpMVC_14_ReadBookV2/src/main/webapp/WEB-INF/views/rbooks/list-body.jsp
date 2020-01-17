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
		document.location.href="${rootPath}/rbook/insert"
	})
	
	$("#main-table tbody tr").click(function(){
		let rb_seq = $(this).attr("data-id")
		document.location.href = "${rootPath}/rbook/view/" + rb_seq
	})
})
</script>
</head>
<body>
	<section id="main-list">
		<table id="main-table">
			<thead>
				<tr>
					<th>사용자ID</th>
					<th>도서코드</th>
					<th>도서이름</th>
					<th>독서일자</th>
					<th>독서시간</th>
					<th>한줄평</th>
					<th>별점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${RBOOKS}" var="rBook">
					<tr data-id="${rBook.rb_seq}">
						<td>사용자ID</td>
						<td>${rBook.rb_bcode}</td>
						<td>${rBook.rb_bname}</td>
						<td>${rBook.rb_date}</td>
						<td>${rBook.rb_stime}</td>
						<td>${rBook.rb_subject}</td>
						<td>${rBook.rb_star}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section>
		<div id="main-button">
			<button id="btn-write" class="biz-blue flex-right">독서록 작성</button>
		</div>
	</section>
	
</body>
</html>