<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="${rootPath}/css/pro-main.css?ver=2019-12-23">
<body>
<form id="search-form">
<input type="search" 
		class="form-control" 
		id="search-input" 
		name="search" 
		value="${search}" 
		placeholder="상품이름을 입력한 후 엔터">
</form>
<hr/>
<table class="p-list table table- strped table-hover">
<thead class="thead-dark">
<tr>
<th>상품코드</th>
<th>상품이름</th>
<th>매입단가</th>
<th>매출단가</th>
<th>대표이미지</th>
<th>보조이미지</th>
</tr>
</thead>
<c:forEach items="${PLIST}" var="vo">
<tr class="p-row" data-id="${vo.p_code}">
<td>${vo.p_code}</td>
<td>${vo.p_name}</td>
<td>${vo.p_iprice}</td>
<td>${vo.p_oprice}</td>
<td><c:if test="${!empty vo.p_file}">O</c:if></td>
<td><c:if test="${!empty vo.p_files}">O(${fn:length(vo.p_files)}) </c:if></td>
</tr>
</c:forEach>
</table>
<hr/>
<section>
<%@ include file="/WEB-INF/views/pagenation.jsp" %>
</section>

</body>
</html>