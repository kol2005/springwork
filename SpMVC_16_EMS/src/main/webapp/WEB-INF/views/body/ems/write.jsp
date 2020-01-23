<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.js"></script>		
<script src="${rootPath}/static/js/summernote-ko-KR.js"></script>

<script>
$(function(){
	
	var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
		[ 'fontsize', [ 'fontsize' ] ],
		[ 'font Style', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
		[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
		[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
		[ 'insert', [ 'link', 'hr', 'picture' ] ],
		[ 'view', [ 'fullscreen', 'codeview' ] ] ]

	$("#content").summernote({
		lang : 'ko-KR',
		placeholder : '본문을 입력하세요',
		width : '100%',
		toolbar : toolbar,
		height : '200px',
		disableDragAndDrop : false
	})
	
})

</script>
<fieldset class="email-write-box">

<form:form modelAttribute="emailVO">

<div class="in-box">
<label for="fromEmail">보내눈 Email</label>
<form:input path="fromEmail"/>
</div>

<div class="in-box">
<label for="to_email">받는 Email</label>
<form:input path="to_email"/>
</div>

<div class="in-box">
<label for="sendDate">작성일자</label>
<form:input path="sendDate"/>
</div>

<div class="in-box">
<label for="sendTime">작성시간</label>
<form:input path="sendTime"/>
</div>

<div class="in-box">
<label for="fromName">작성자</label>
<form:input path="fromName"/>
</div>

<div class="in-box">
<label for="to_name">받는사람</label>
<form:input path="to_name"/>
</div>

<div class="in-box">
<label for="subject">제목</label>
<form:input path="subject"/>
</div>

<div class="in-box">
<form:textarea path="content"/>
</div>

<div class="in-box">
<button>메일보내기</button>
</div>



</form:form>
</fieldset>