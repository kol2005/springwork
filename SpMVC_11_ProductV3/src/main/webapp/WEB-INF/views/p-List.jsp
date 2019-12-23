<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
$(function(){
	$("tr.p-row").click(function(){
		let p_code = $(this).attr("data-id")
		$.ajax({
			
			// "getProduct?"p_code=" + p_code"
			url : "${rootPath}/rest/getProduct",
			data : {p_code : p_code},//p_code
			dataType : 'json',
			success : function(result){
				$("#p_code").val(result.p_code)
				$("#p_name").val(result.p_name)
				$("#p_iprice").val(result.p_iprice)
				$("#p_oprice").val(result.p_oprice)
				//$("#p_file").val(result.p_file)
				
				let image = "${rootPath}/files/noimage.png"
					$("#p_sub_list").html("")
				if(result.p_files.length > 0){
					
					
					result.p_files.forEach(function(file){
						$("#p_sub_list").append(
						$("<img/>",{
							width:"500px",
							height:"500px",
							src : "${rootPath}/files/" + file.file_upload_name
						})
						)
					})
				}
			},
			error : function(){
				alert("서버통신 오류")
			}
		})
		
	})
})
</script>
<body>
<table border="1" class="p-list">
<tr>
<th>상품코드</th>
<th>상품이름</th>
<th>매입단가</th>
<th>매출단가</th>
<th>파일</th>
</tr>
<c:forEach items="${PLIST}" var="vo">
<tr class="p-row" data-id="${vo.p_code}">
<td>${vo.p_code}</td>
<td>${vo.p_name}</td>
<td>${vo.p_iprice}</td>
<td>${vo.p_oprice}</td>
<td><c:if test="${vo.p_files.length > 1}">파일있음</c:if></td>
</tr>
</c:forEach>
</table>

</body>
</html>