<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script src="${rootPath}/js/summernote-ko-kr.min.js"></script>
<style>
	.card-header h3{
	display: inline-block;
	width: auto;
	padding: 5px 15px; 
	}
</style>

<script>
$(function(){
	$("button.btn-c-save").click(function(){
		let cmt_writer = $("#cmt_writer").val()
		let cmt_text = $("#cmt_text").val()
		
		if(cmt_writer == ""){
			alert("댓글 작성자를 입력하세요")
			$("#cmt_writer").focus()
			return false
		}
		if(cmt_text == ""){
			alert("댓글을 입력하세요")
			$("#cmt_text").focus()
			return false
		}
		
		// json 형태로 데이터 생성
		let cmt_data = {
				cmt_p_id:'${bbsVO.bbs_id}',
				cmt_writer:cmt_writer,
				cmt_text:cmt_text
				}
		
		$.ajax({
			url : '${rootPath}/bbs/cmt_write',
			method:'POST',
			data: cmt_data,
			success: function(result) {
				//alert(result)
				$("#cmt_list").html(result)
			},
			error: function() {
				alert("서버와 통신 오류")
			}
		})
	})
})
</script>

<article class="card">
<table class="table .table-striped card-header">

	<tr>
		<th>작성일자</th>
		<td>${BBS.bbs_date}</td>
	</tr>
	<tr>
		<th>작성시각</th>
		<td>${BBS.bbs_time}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${BBS.bbs_writer}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${BBS.bbs_subject}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${BBS.bbs_content}</td>
	</tr>




</table>
</article>

<div class="card-body bg-info">
<div id="cmt_list" class="form-group bg-default">
댓글 리스트 보기
</div>
	<div class="form-group">
		<input id="cmt_writer" name="cmt_writer" class="form-control" placeholder="작성자">
	</div>
	<div class="form-group">
		<input id="cmt_text" name="cmt_text" class="form-control">
		<button class="btn btn-dark btn-c-save">저장</button>
	</div>
</div>

<div class="btn-group">
<button type="button" class="btn btn-primary">리스트</button>
<button type="button" class="btn btn-success">수정</button>
<button type="button" class="btn btn-warning">삭제</button>
</div>

<c:if test="${bbsVO.bbs_p_id == 0}">
<script>
$(function(){
	
	// 현재 페이지가 모두 그려진 후 바로 실행하라
	$.post("${rootPath}/bbs/cmt_list",
			{cmt_p_id:"${bbsVO.bbs_id}"},
		function(result){
		$("#cmt_list").html(result)
	})
	
	
	var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
		[ 'fontsize', [ 'fontsize' ] ],
		[ 'font Style', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
		[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
		[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
		[ 'insert', [ 'link', 'hr', 'picture' ] ],
		[ 'view', [ 'fullscreen', 'codeview' ] ] ]

	$("#bbs_content").summernote({
		lang:"ko-kr",
		height: "200px",
		toolbar: toolbar,
		disableDragAndDrop: false
	})
	
	$("button.btn-r-save").click(function(){

		let bbs_writer = $("#bbs_writer").val()
		let bbs_content = $("#bbs_conten").val()
		
		if(bbs_writer == ""){
			alert('작성자를 입력하세요')
			$("#bbs_writer").focus()
			return false
		}
		if(bbs_content == ""){
			alert("답글을 입력하세요")
			$("#bbs_content").focus()
			return false
		}
		$("form").submit()	
		
	})
	
})
</script>
<form:form action="${rootPath}/bbs/replay" modelAttribute="bbsVO">
<div class="form-group">
<input class="form-control" id="bbs_writer" name="bbs_writer" placeholder="답글 작성자"/>
</div>
	<textarea name="bbs_content" id="bbs_content"></textarea>
	<button class="btn btn-info btn-r-save" type="button">답글저장</button>
</form:form>
</c:if>

