<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/list-table.css?ver=2019-12-02" >
	<table>
		<tr>
			<th>SQ</th>
			<th>작성일</th>
			<th>작성시각</th>
			<th>작성자</th>
			<th>카테고리</th>
			<th>제목</th>
		</tr>
		<c:choose>
			<c:when test="${empty MEMO_LIST eq NULL}">
				<tr>
					<td colspan="6">메모가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${MEMO_LIST}" var="memo" varStatus="index">
					<tr class="content-body" data-id="${memo.m_seq}">
						<td>${index.count}</td>
						<td>${memo.m_date}</td>
						<td>${memo.m_time}</td>
						<td>${memo.m_auth}</td>
						<td>${memo.m_cat}</td>
						<td>${memo.m_subject}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>