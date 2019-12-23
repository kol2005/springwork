<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
</head>
<body>
<table border="1" class="p-list">
<tr>
<th>상품코드</th>
<th>상품이름</th>
<th>매입단가</th>
<th>매출단가</th>
</tr>
<c:forEach items="${PLIST}" var="vo">
<tr>
<td>${vo.p_code}</td>
<td>${vo.p_name}</td>
<td>${vo.p_iprice}</td>
<td>${vo.p_oprice}</td>
</tr>
</c:forEach>
</table>

</body>
</html>