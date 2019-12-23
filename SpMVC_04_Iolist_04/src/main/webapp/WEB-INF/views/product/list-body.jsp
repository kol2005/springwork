<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${rootPath}/css/list-table.css?ver=2019-11-31-001" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function() {
	$(".content-body").click(function(){
		
		//this : tr
		// 의 자손들(td)을 추출하여 mTd에 저장해달라
		let mTd = $(this).children()
		let strNo = mTd.eq(0).text()
		let strCode = mTd.eq(1).text()
		let strName = mTd.eq(2).text()
		let strIPrice = mTd.eq(3).text()
		let strOPrice = mTd.eq(4).text()
		/*
		alert(strNo + "\n"
			+ strCode + "\n"
			+ strName + "\n"
			+ strIPrice + "\n"
			+ strOPrice + "\n")
	*/
	$("#io_pcode",opener.document).val(strCode)
	$("#io_pname",opener.document).text(strName)
	
	let strInout = $("#io_inout",opener.document).val()
	//let strInout = $(opener.document).find("#io_inout").val
	
	if(strInout == "1"){
		$("#io_price",opener.document).val(strIPrice)	
	}else{
		$("#io_price",opener.document).val(strOPrice)
	}
	
	// 수량 * 단가 = 합계 계산하여 붙여넣기
	let price = $("#io_price",opener.document).val()
	let qty= $("#io_qty",opener.document).val()
	$("#io_total",opener.document).val(parseInt(price)*parseInt(qty))
	
	window.close()
	
	// IE 때문에 쓸데없이 쓰는 코드
	// '창을 닫을까요' 물어보지 않기
	window.open("about:blank","_self").self.close()
	
	})
})
</script>
<body>
<section>
<article>
<p id="insert"><a href="${rootPath}/product/insert"><button>새로등록</button></a>
</article>
<style>
div.s-box{
width:95%;
margin:0 auto;
}
div.s-box input{
padding:8px;
width:100%;
}
</style>
<article>
<div class="s-box">
<form>
<input name="strText">
</form>
</div>
<table>
<tr>
<th>NO</th>
<th>상품코드</th>
<th>상품명</th>
<th>매입가</th>
<th>매출가</th>
<th>부가세</th>
</tr>
<c:choose>
<c:when test="${empty PRODUCTLIST}">
<tr><td colspan="5">데이터가 없음</td></tr>
</c:when>
<c:otherwise>
<c:forEach items="${PRODUCTLIST}" var="dto" varStatus="info">
<tr class="content-body" id="${dto.p_code}">
<td>${info.count}</td>
<td>${dto.p_code}</td>
<td>${dto.p_name}</td>
<td>${dto.p_iprice}</td>
<td>${dto.p_oprice}</td>
<td>${dto.p_vat}</td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
</article>
</section>
</body>
</html>