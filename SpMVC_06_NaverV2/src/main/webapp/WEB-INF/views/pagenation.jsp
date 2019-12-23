<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<style>
.page-box {
	width: 95%;
	margin: 15px auto;
	padding: 16px;
	border-top: 1px solid green;
	border-buttom: 1px solid green;
}

.page-body {
	list-style: none;
	display: flex;
	justify-content: center;
	align-items: center;
}

.page-link {
	position: relative;
	display: block;
	padding: 0.5rem 0.75rem;
	line-height: 1.25;
	color: #007bff;
	background-color: #fff;
	border: 1px solid #dee2e6;
	text-decoration: none;
}

.page-link:hover {
	color: #0056b3;
	background: #e9ecef;
	border-color: #dee2e6;
}

.page-link:focus {
	z-index: 3;
	outline: 0;
	box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}

.page-item.active .page-link {
	z-index: 3;
	color: #fff;
	background-color: #007bff;
	border-color: #007bff;
}
</style>
</head>
<body>
	<article class="page-box">
		<ul class="page-body">
			<li class="page-item"><a href="${rootPath}/search?cat=${cat}&search=${search}&currentPageNo=${PAGE.firstPageNo}" class="page-link">[처음]</a>
			<li class="page-item"><a href="${rootPath}/search?cat=${cat}&search=${search}&currentPageNo=${PAGE.prePageNo}" class="page-link">&lt;</a> 
			<c:forEach	begin="${PAGE.startPageNo}" end="${PAGE.endPageNo}" var="page">
					<li	class="page-item <c:if test='${page == PAGE.currentPageNo}'>active</c:if>">
						<a href="${rootPath}/search?search=${search}&cat=${cat}&currentPageNo=${page}" class="page-link">${page}</a>
				</c:forEach>
			<li class="page-item"><a href="${rootPath}/search?cat=${cat}&search=${search}&currentPageNo=${PAGE.nextPageNo}" class="page-link">&gt;</a>
			<li class="page-item"><a href="${rootPath}/search?cat=${cat}&search=${search}&currentPageNo=${PAGE.finalPageNo}" class="page-link">[끝]</a>
		</ul>
	</article>

</body>
</html>