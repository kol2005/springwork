<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구리스트</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Popper JS -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css"	rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script src="${rootPath}/js/summernote-ko-kr.min.js"></script>

<script>
$(function(){
	
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
	// 정보입력
	$("#btn-insert").click(function(){
		document.location.href = '${rootPath}/friend/insert'
	})
	// 정보 클릭했을때 view창 자세히보기
	$(".table-info").click(function(){
		let f_id = $(this).attr("data-id")
		document.location.href = '${rootPath}/friend/view?f_id=' + f_id
	})
	
	// 검색 : <input> tag 
	$("#btn-search").click(function(){
		let f_name = $("#f-search").val()// id="f-search" 를 f_name에 넣어라?
		//$(f_name).submit()
		document.location.href = '${rootPath}/friend/search?f_name=' + f_name
	})

	
	
})
</script>

<style>
header{
justify-content: center;
background-color: red;
padding: 10px;
}

h1{
color:blue;
text-align: center;
}

table{
padding: 10px;
}

thead{

font-weight: bold;
}

</style>

</head>
<header>
	<h1>친구정보</h1>
</header>
<body>
<div class="container">
	<table class="table">

		<thead>
			<tr class="table-success">
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>관계</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="LIST" items="${FRIENDLIST}">
				<tr class="table-info" data-id="${LIST.f_id}">
					<td>${LIST.f_name}</td>
					<td>${LIST.f_tel}</td>
					<td>${LIST.f_addr}</td>
					<td>${LIST.f_hobby}</td>
					<td>${LIST.f_relation}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
			<button id="btn-insert" type="button" class="btn btn-primary">정보등록</button>
			<input class="#" id="f-search" name="f-search" placeholder="이름으로 검색">
			<button id="btn-search" type="button" class="btn btn-outline-success">검색</button>
</div>

</body>
</html>