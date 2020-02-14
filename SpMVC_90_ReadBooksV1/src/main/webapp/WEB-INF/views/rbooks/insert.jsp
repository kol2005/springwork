<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>독서록 작성</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script>
$(function(){
	
	$("#btn_rbook_insert").click(function(){
		
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
			//openInNewWindow("${rootPath}/rbook/search?strText=" + strText,"_blank",status)
			window.open("${rootPath}/rbook/search?strText=" + strText,"_blank",status)
			if(strText == ""){
				alert("도서이름을 입력한 후 Enter")
				return false
			}
		}
	})
})
</script>
<style>
h3{
padding: 20px;
border-top: 20px;
text-align: center;
}
.in-box{
width:700px;
border: center;
justify-content: center;
text-align: center;
font-size: 20px;
padding: 5px;
background-color: #66adff;
}
.books-form{
background-color: #d9d9d9;
text-align: center;
}
</style>
</head>
<body>

	<h3>독서록 작성</h3>
	<form:form modelAttribute="rBookVO" class="books-form container p-3 my-3 border">
	
	<form:input path="rb_bcode"  class="in-box" placeholder="ISBN"/><br/>
	<form:input path="rb_bname" class="in-box" placeholder="책 이름"/><br/><br>
	<form:input path="rb_date" class="in-box" placeholder="날짜"/><br/>
	<form:input path="rb_stime" class="in-box" placeholder="현재 시간"/><br/>
	<form:input path="rb_rtime" class="in-box" placeholder="읽은 시간"/><br/>
	<form:input path="rb_subject" class="in-box" placeholder="한줄평"/><br/>
	<form:input path="rb_text" class="in-box" placeholder="내용"/><br/>
	<form:input path="rb_star" class="in-box" placeholder="별점"/><br/>
	<br>
	<button id="btn_rbook_insert" class="bz-button btn btn-success">저장</button>
	</form:form>

</body>
</html>