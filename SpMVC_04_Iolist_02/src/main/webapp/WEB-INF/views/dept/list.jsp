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
		
		// id에 설정된 값을 가져오기
		let d_code = $(this).attr("id")
		
		//alert(d_code)
		// 현재 페이지를 dept/view를 전환하라
		// 주소창에 /dept/view를 입력하여 서버에 전송하라
		// id 변수에 값을 실어서 보내라
		document.location.href = "${rootPath}/dept/view?d_code=" + d_code
	})
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-dept-header.jspf" %>
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
<tr class="content-body" id="${dto.d_code}">
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