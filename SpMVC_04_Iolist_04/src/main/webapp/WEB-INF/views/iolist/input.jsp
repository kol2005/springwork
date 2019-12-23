<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개돼지 등록</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	var rootPath = "${pageContext.request.contextPath}"
</script>
<script src="${rootPath}/js/iolist-input-1.0.js?ver2019-11-30-003"></script>
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
.in-box > select{
padding: 8px;
margin:3px;
display: inline-block;
width:72%;
border:1px solid #ccc;
}
.in-box > input[type="radio"]{
padding: 8px 0 ;
margin:5px 0;
display: inline-block;
width:10%;
border:1px solid #ccc;
}
.in-box > input#io_pcode, .in-box > input#io_dcode{
width:30%;
}
span{
color:blue;
font-weight: bold;
font-style: italic;
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
<%@ include file="/WEB-INF/views/include/include-iolist-header.jspf" %>
<form method="POST">
<fieldset>
<legend>매입매출 입력</legend>

<input name="io_seq" id="io_seq" type="hidden" value="<c:out value='${IO_DTO.io_seq}' default='0'/>" >

<label for="io_dcode" class="in-label">거래처코드</label>
<div class="in-box">
<input name="io_dcode" id="io_dcode" >
<span id="io_dname">거래처명</span>
</div>

<label for="io_inout" class="in-label">거래구분</label>
<div class="in-box">
<select name="io_inout" id="io_inout">
<option value="1">매입</option>
<option value="0">매출</option>
</select>
</div>

<label for="io_pcode" class="in-label">상품코드</label>
<div class="in-box">
<input name="io_pcode" id="io_pcode" >
<span id="io_pname">상품이름</span>
</div>

<label for="io_vat" class="in-label">과세구분</label>
<div class="in-box">
<label for="io_vat_1">과세</label>
<input type="radio" name="io_vat" id="io_vat_1" value="1">
<label for="io_vat_2">면세</label>
<input type="radio" name="io_vat" id="io_vat_2" value="0">
</div>

<label for="io_date" class="in-label">거래일자</label>
<div class="in-box">
<input type="date" name="io_date" id="io_date" value="${IO_DTO.io_date}">>
</div>

<!-- type default text
type을 지정해주면 mobile에서 상황에 맞는 키보드를 볼수 있다 -->
<label for="io_qty" class="in-label">수량</label>
<div class="in-box">
<input name="io_qty" id="io_qty" type="number" value="<c:out value='${IO_DTO.io_qty}' default='0'/>" >
</div>

<label for="io_price" class="in-label">단가</label>
<div class="in-box">
<input name="io_price" id="io_price" type="number" value="<c:out value='${IO_DTO.io_price}' default='0'/>" >
</div>

<label for="io_total" class="in-label">합계</label>
<div class="in-box">
<input name="io_total" id="io_total" value="<c:out value='${IO_DTO.io_total}' default='0'/>" >
</div>



<label class="in-label"></label>
<div class="in-box">
<button id="btn-save" type="button">저장</button>
</div>

</fieldset>
</form>

</body>
</html>