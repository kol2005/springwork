<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개돼지 거래정보</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf" %>
</head>
<style>
.in-box{
display: inline-block;
width: 70%;
}
.in-box > input{
padding: 8px;
margin: 3px;
display: inline-block;
width: 70%;
border: 1px solid #ccc;
}
.in-box > input:hover{
background-color: #ddd;
border: 1px solid blue;
}
.in-label{
display: inline-block;
width: 20%;
text-align: right;
margin-right: 5px;
padding: 8px;
}
filedset{
width: 70%;
margin: 20px auto;
border-radius: 5px;
}
legend{
font-size: 12pt;
font-weight: bold;
color: #3d65ff;
}
</style>
<body>
<%@ include file="/WEB-INF/views/include/include-product-header.jspf" %>
<form method="POST">
<fieldset>
<legend>매입매출 정보 입력</legend>
<label for="p_code" class="in-label">상품코드</label>
<div class="in-box">
<input name="p_code" id="p_code" value="${DI.p_code}" readonly="readonly">
</div>

<label for="p_name" class="in-label">상품이름</label>
<div class="in-box">
<input name="p_name" id="p_name" value="${DI.p_name}">
</div>

<label for="p_iprice" class="in-label">매입가격</label>
<div class="in-box">
<input name="p_iprice" id="p_iprice" value="${DI.p_iprice}">
</div>

<label for="p_oprice" class="in-label">매출가격</label>
<div class="in-box">
<input name="p_oprice" id="p_oprice" value="${DI.p_oprice}">
</div>

<label for="p_vat" class="in-label">부가세</label>
<div class="in-box">
<input name="p_vat" id="p_vat" value="${DI.p_vat}">
</div>

<label class="in-label"></label>
<div class="in-box">
<button id="btn-save">저장</button>
</div>

</fieldset>
</form>
</body>
</html>