<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<Script>
	$(function() {
		$("#t_city").change(function() {
			//let city_code = $(this).val()
			//alert(city_code)
			$("#t_sigun").val(1)
			$("form").submit()
		})
		
		$("#t_sigun").change(function() {
			//let city_code = $(this).val()
			//alert(city_code)
			$("form").submit()
		})
		
		
		
		
		
		$(".hc").click(function() {
			let id = $(this).attr("data-id")
			alert(id)
		})
	})
</Script>
</head>
<body>
	<header>
		<form:form modelAttribute="tourDTO" method="GET">
			<form:select path="t_city">
				<form:options items="${CITY}" itemLabel="name" itemValue="code" />
			</form:select>
			<form:select path="t_sigun">
				<form:options items="${SI}" itemLabel="name" itemValue="code" />
			</form:select>
		</form:form>
	</header>
	<section>
		<div>
			<c:choose>
				<c:when test="${empty BASELIST}">
					<p>데이터를 찾을 수 없음
				</c:when>
				<c:otherwise>
					<c:forEach items="${BASELIST}" var="base">
						<h3>${base.title}</h3>
						<p>주소:${base.addr1}</p>
						<p>동명:${base.addr2}</p>
						<p>전화번호:${base.tel}</p>
						<p>
							<img width="100px" src="${base.firstimage}" alt="정보이미지">
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</body>
</html>