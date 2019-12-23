<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf" %>
</head>
<style>
.in-box{
display: inline-block;
width:70%;
}
.in-box > input{
padding: 8px;
margin:3px;
display: inline-block;
width:70%;
border:1px solid #ccc;
}
.in-box > input:hover{
background-color: #ddd;
border:1px solid blue;
}
.in-label{
display: inline-block;
width:20%;
text-align: right;
margin-right: 5px;
padding: 8px;
}
fieldset{
width:70%;
margin:20px auto;
border-radius: 5px;
}
legend{
font-size: 12pt;
font-weight: bold;
color: #3d65ff;
}
</style>
<body>
<%@ include file="/WEB-INF/views/include/include-dept-header.jspf" %>
<form method="POST">
<fieldset>
<legend>거래처정보 입력</legend>
<!-- label의 for속성 : input box와 한 그룹으로 설정 label을 클릭했을때
마치 input box를 클릭한 것처럼 input box에 focus를 지정하는 것 -->
<label for="d_code" class="in-label">개돼지번호</label>
<div class="in-box">
<input name="d_code" id="d_code" value="${DI.d_code}" readonly="readonly">
</div>

<label for="d_name" class="in-label">개돼지명</label>
<div class="in-box">
<input name="d_name" id="d_name" value="${DI.d_name}">
</div>

<label for="d_ceo" class="in-label">대장</label>
<div class="in-box">
<input name="d_ceo" id="d_ceo" value="${DI.d_ceo}">
</div>

<label for="d_tel" class="in-label">멍멍꿀꿀번호</label>
<div class="in-box">
<input name="d_tel" id="d_tel" value="${DI.d_tel}">
</div>

<label for="d_addr" class="in-label">개돼지집</label>
<div class="in-box">
<input name="d_addr" id="d_addr" value="${DI.d_addr}">
</div>

<label class="in-label"></label>
<div class="in-box">
<button id="btn-save">저장</button>
</div>

</fieldset>
</form>

</body>
</html>