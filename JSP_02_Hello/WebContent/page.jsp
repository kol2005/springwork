<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 웹브라우저에서 query로 전달받은 변수(strName) 값을 추출하여
// 문자열 변수 strName에 저장하라
String strName = request.getParameter("strName");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나의 정보</h3>
<!-- strName 변수 값을 화면에 보여라 -->
<p>나는 (<%= strName %>)입니다.
<p><% out.write("대한민국"); %>
<p><% out.write(30*40); %>
<p>
<%int sum = 30 + 40;
out.write(sum); %>
</body>
</html>