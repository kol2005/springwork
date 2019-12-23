<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- anchor : 닻 -->
	<!-- 다른 곳으로 연결하는 링커 -->
	<!-- hyper text의 꽃 -->
	<!-- 해당 문자열(네이버검색)을 클릭하면
href="" 에 설정된 곳으로 jump 하는 코드
 -->
	<p>
		<a href=https://search.naver.com/search.naver?query=대한민국>네이버검색</a>
	<p>
		<a href=https://search.naver.com/search.naver?q=대한민국>네이버검색2</a>
	<p>네이버검색</p>
	<!-- input box, input tag -->
	<form action="https://search.naver.com/search.naver">
		<p><input name="query">
		<p><input name="num1">
		<p><input name="num2">
		<!-- 누름단추 -->
		<button>검색</button>
	</form>
</body>
</html>