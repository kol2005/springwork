<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
p#insert{
margin: 20px;
}
</style>
<script>
$(function() {
	$(".content-body").click(function(e){
		let p_code = $(this).attr("id")
		document.location.href="${rootPath}/product/view?p_code="+p_code
	})
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-product-header.jspf" %>
<section>
<article>
<p id="insert"><a href="${rootPath}/product/insert"><button>새로등록</button></a>
</article>

<article>
<table>
<tr>
<th>NO</th>
<th>상품코드</th>
<th>상품명</th>
<th>매입가</th>
<th>매출가</th>
<th>부가세</th>
</tr>
<c:choose>
<c:when test="${empty PRODUCTLIST}">
<tr><td colspan="5">데이터가 없음</td></tr>
</c:when>
<c:otherwise>
<c:forEach items="${PRODUCTLIST}" var="dto" varStatus="info">
<tr class="content-body" id="${dto.p_code}">
<td>${info.count}</td>
<td>${dto.p_code}</td>
<td>${dto.p_name}</td>
<td>${dto.p_iprice}</td>
<td>${dto.p_oprice}</td>
<td>${dto.p_vat}</td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
</article>
</section>
</body>
</html>