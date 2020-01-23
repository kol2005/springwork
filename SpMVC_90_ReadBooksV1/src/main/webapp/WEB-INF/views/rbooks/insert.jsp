<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리드북인서트</title>
<script>
$(function(){
	
	$("#btn_rbook_insert").click(function(){
		//if($("#rb_bcode").val() == ""){
			//alert("도서 코드는 반드시 입력해야 합니다")
			//$("#rb_bcode").focus()
			//return false
		//}
		if(parseInt($("#rb_rtime").val()) < 1){
			alert("도서 시간은 반드시 입력해야 합니다")
			$("#rb_rtime").focus()
			return false
		}
		if($("#rb_subject").val() == ""){
			alert("한줄평은 반드시 입력해야 합니다")
			$("#rb_subject").focus()
			return false
		}
		//$("form").submit()
		document.location.href = "${rootPath}/rbooks/insert"
	})
	$("#rb_bname,#rb_rtime,#rb_bcode,#rb_subject").focus(function(){
		$(this).select()
	})
	
	$("#rb_bname").keypress(function(event){
		if(event.keyCode == 13){
			let strText = $(this).val()
			if(strText == ""){
				alert("도서이름을 입력한 후 Enter")
				return false
			}
			
		}
		
	})

	
})
</script>
</head>
<body>

	<fieldset>
	<legend>리드북인서트</legend>
	<form:form modelAttribute="rBookVO" class="books-form">
	
	<form:input path="rb_bcode"  class="in-box" type="hidden" placeholder="ISBN"/><br/>
	<form:input path="rb_bname" class="in-box" placeholder="책 이름"/><br/>
	<form:input path="rb_date" class="in-box" placeholder="날짜"/><br/>
	<form:input path="rb_stime" class="in-box" placeholder="s타임"/><br/>
	<form:input path="rb_rtime" class="in-box" placeholder="r타임"/><br/>
	<form:input path="rb_subject" class="in-box" placeholder="한줄평"/><br/>
	<form:input path="rb_text" class="in-box" placeholder="내용"/><br/>
	<form:input path="rb_star" class="in-box" placeholder="별점"/><br/>
	<button id="btn_rbook_insert">저장</button>
	</form:form>
	</fieldset>

</body>
</html>