<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>

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
body {
	border: 1px solid #aaa;
}
</style>

<script>
	$(function() {
		
		var toolbar = [ [ 'style', [ 'bold', 'italic', 'underline' ] ],
			[ 'fontsize', [ 'fontsize' ] ],
			[ 'font Style', [ 'fontname' ] ], [ 'color', [ 'color' ] ],
			[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
			[ 'height', [ 'height' ] ], [ 'table', [ 'table' ] ],
			[ 'insert', [ 'link', 'hr', 'picture' ] ],
			[ 'view', [ 'fullscreen', 'codeview' ] ] ]

		
		$(".bbs-list").click(function(){
			let bbs_id = $(this).attr("data-id")
			document.location.href = '${rootPath}/bbs/view?bbs_id=' + bbs_id
		})
		
		$("#btn-write").click(function() {
			document.location.href = '${rootPath}/bbs/input'
		})
		
		
		$("#bbs_content").summernote({
			lang:"ko-kr",
			height: "200px",
			toolbar: toolbar,
			disableDragAndDrop: false
		})
		
	})
</script>
</head>

<header class="jumbotron text-conter">
	<h3>빌드 보드 시스템</h3>
</header>
<ul class="nav">
	<li class="nav-item"><a class="nav-link" href="${rootPath}/">home</a></li>
	<li class="nav-item justify-content-end"><a class="nav-link" href="${rootPath}/member/login">로그인</a></li>
	<li class="nav-item"><a class="nav-link" href="${rootPath}/member/join">회원가입</a></li>
</ul>
<body class="container-fluide">

	<section>
		<c:choose>
			<c:when test="${BODY == 'BBS_INPUT'}">
				<%@ include file="/WEB-INF/views/include/bbs_input.jsp"%>
			</c:when>

			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/bbs_list.jsp"%>
				
				<div class="input-group">
					<div class="input-group-btn">
						<button id="btn-write" class="btn btn-primary" type="button">게시판작성</button>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</section>



</body>
</html>