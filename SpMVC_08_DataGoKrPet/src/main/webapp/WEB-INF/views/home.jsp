<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>펫 라이프</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#s_cat").change(function() {
			$("form").submit()
		})

		/*
		아직은 모든 브라우저에서 지원하지 않지만
		type="search"인 input box에서 clear 버튼을 눌렀을때
		발생하는 이벤트르 catch 하여 처리가능
		*/
		$("#s_text").on("search", function() {
			$("form").submit()
		})
	})
</script>
<style>
header {
	background-color: rgba(0, 255, 0, 0.3);
	color: blue;
	text-align: center;
	padding: 0.9rem;
	text-transform: uppercase;
}

nav {
	background-color: green;
}

nav input {
	width: 300px;
	margin: 10px;
	border: 1px solid orange;
	border-radius: 20px;
	position: relative;
	padding: 16px 14px;
}

nav select{
width:300px;
padding:8px 0.5rem;
border: 1px solid orange;

background:url('${rootPath}/images/arrow.png') no-repeat 95% 50%;
background-color: wihte;

appearance:none;
-moz-appearance:none; 
-webkit-appearance:none;
}

nav input:hover:after {
	content: '동물병원 이름이나 주소를 입력하고 Enter를 누르세요';
	position: absolute;
	top: 20px;
	left: 30px;
}


</style>
</head>
<body>
	<header>
		<h3>마이 펫 라이프</h3>
	</header>
	<nav>
		<form:form modelAttribute="searchVO" method="GET">
			<form:select path="s_cat">
				<form:option value="hs">병원명</form:option>
				<form:option value="addr">주소</form:option>
			</form:select>
			<form:input type="search" path="s_text" placeholder="검색어를 입력한후 엔터" />

		</form:form>
	</nav>
	<section class="list">
		<table class="list">
			<tr>
				<th>동물병원의 이름</th>
				<th>도로명주소</th>
				<th>지번주소</th>
				<th>대행업소의 연락처</th>
				<th>위도</th>
				<th>경도</th>
				<th>데이터기준일</th>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${empty H_LIST}">
						<tr>
							<td colspan="7">데이터가 없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${H_LIST}" var="hs" varStatus="index">
							<tr>
								<td>${hs.apiDongName}</td>
								<td>${hs.apiNewAddress}</td>
								<td>${hs.apiOldAddress}</td>
								<td>${hs.apiTel}</td>
								<td>${hs.apiLat}</td>
								<td>${hs.apiLng}</td>
								<td>${hs.apiRegDate}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		</table>
	</section>

</body>
</html>