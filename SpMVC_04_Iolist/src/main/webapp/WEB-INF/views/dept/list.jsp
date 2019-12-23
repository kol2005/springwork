<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개돼지 정보 페이지</title>
<link rel="stylesheet" href="${rootPath}/css/dept-main.css?ver=20191125001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/list-table.css?ver=20191125001" type="text/css">
<style type="text/css">
p#insert{
margin: 20px;
}
</style>
</head>
<body>
<header>
<h3>개돼지 정보관리</h3>

</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section>
<article>
<p id="insert"><a href="${rootPath}/dept/insert"><button>새로등록</button></a>

</article>
<article>
<table>
<tr>
<th>NO</th>
<th>거래처코드</th>
<th>거래처명</th>
<th>대표</th>
<th>전화번호</th>
<th>주소</th>
</tr>
<c:choose>
<c:when test="${empty DEPTLIST}">
<tr><td colspan="5">데이터가 없음</td></tr>
</c:when>
<c:otherwise>
<c:forEach items="${DEPTLIST}" var="dto" varStatus="info">
<tr class="content-body">
<td>${info.count}</td>
<td>${dto.d_code}</td>
<td>${dto.d_name}</td>
<td>${dto.d_ceo}</td>
<td>${dto.d_tel}</td>
<td>${dto.d_addr}</td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
</article>
</section>
</body>
</html>