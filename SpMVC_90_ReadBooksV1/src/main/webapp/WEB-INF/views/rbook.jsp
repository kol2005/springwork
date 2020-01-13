<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>

	<table>
		<c:if test="${!empty rbList}">
			<c:forEach items="${rbList}" var="rbook">
				<tr>
					<td>${rbook.rb_seq}</td>
					<td>${rbook.rb_bcode}</td>
					<td>${rbook.rb_date}</td>
					<td>${rbook.rb_stime}</td>
					<td>${rbook.rb_rtime}</td>
					<td>${rbook.rb_subject}</td>
					<td>${rbook.rb_text}</td>
					<td>${rbook.rb_star}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>