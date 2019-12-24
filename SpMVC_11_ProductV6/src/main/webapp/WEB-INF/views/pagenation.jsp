<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<article>
	<ul class="pagination">
		<c:if test="${pageDTO.startPageNo > 1}">
			<li class="page-item"><a class="page-link"  href="${rootPath}/${url}?currentPageNo=1">1</a></li>
			<li class="page-item"><a class="page-link"  href="${rootPath}/${url}?currentPageNo=${pageDTO.prePageNo}">&lt;</a></li>
		</c:if>
		
		<c:if test="${pageDTO.startPageNo > 2}">
			<li class="page-item"><a class="page-link" >&middot;&middot;&middot;</a></li>
		</c:if>
		
		<c:forEach begin="${pageDTO.startPageNo}" end="${pageDTO.endPageNo}" var="pageNo">
			<li class="page-item <c:if test="${pageNo == pageDTO.currentPageNo}">active</c:if>">
			<a class="page-link"  href="${rootPath}/${url}?search=${search}&currentPageNo=${pageNo}">${pageNo}</a></li>
		</c:forEach>
		
		<c:if test="${pageDTO.endPageNo != pageDTO.finalPageNo}">
			<li class="page-item"><a class="page-link" >&middot;&middot;&middot;</a></li>
			<li class="page-item"><a class="page-link"  href="${rootPath}/${url}?search=${search}&currentPageNo=${pageDTO.nextPageNo}">&gt;</a></li>
			<li class="page-item"><a class="page-link"  href="${rootPath}/${url}?search=${search}&currentPageNo=${pageDTO.finalPageNo}">${pageDTO.finalPageNo}</a></li>
		</c:if>
	</ul>
</article>