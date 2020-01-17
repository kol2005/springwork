<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css"	rel="stylesheet">
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script>

function bookinfo(b_code){
	document.location.href = "${rootPath}/books/bookinfo?id="+b_code
}

</script>
<script>
var rootPath = "${rootPath}"



$(function(){
	
	$("#btn_book_insert").click(function(){
		document.location.href = "${rootPath}/books/insert"
	})
	
	$("#btn_list").click(function(){
		document.location.href = "${rootPath}/"
	})
	
	var contextCallBack = function(key, options){
		/*
		if(key == 'edit'){
			let b_code = $(this).attr("data-seq")
			document.location.href = "${rootPath}/books/update" + b_code
		}
		*/
		if(key == 'delete'){
			if(confirm("도서정보를 삭제할까요?")){
				let b_code = $(this).attr("b_code")
				
				$.ajax({
					url : "${rootPath}/books/delete",
					data : {
						b_code : b_code
					},
					type : 'POST',
					success : function(result){
						if(result < 1)
							alert("삭제도중 문제발생")
						else
							document.location.replace("${rootPath}/")
					},
					error : function(){
						alert("서버 통신오류")
					}
				})
				return false;
			}
		}
	}
	
	$.contextMenu({
		selector : 'books-l',
		callback : contextCallBack,
		items : {
			//'edit' : {name : '수정',icon : 'edit'},
			'delete' : {name : '삭제',icon : 'delete'}
		}
	})
	
	

	/*
	$(".books-list").click(function(b_code){
		document.location.href = "${rootPath}/bookinfo?b_code"+b_code
	})
	*/
})
</script>

</head>
<body>
<header>
<h3>도서 리스트</h3>
</header>
	<table>
	<tr>
	<td>도서코드</td>
	<td>도서명</td>
	<td>저자</td>
	<td>출판사</td>
	<td>구입일자</td>
	<td>구입가격</td>
	</tr>
	
		<tr>
		<td>
		<c:if test="${!empty bookList}">
		<c:forEach items="${bookList}" var="books">
			<tr class="books-l" onclick="bookinfo('${books.b_code}')">
			<td class="books-list">${books.b_code}</td>
			<td class="books-list">${books.b_name}</td>
			<td class="books-list">${books.b_auther}</td>
			<td class="books-list">${books.b_comp}</td>
			<td class="books-list">${books.b_year}</td>
			<td class="books-list">${books.b_iprice}</td>
			</tr>
		</c:forEach>
		</c:if>
		</td>
		</tr>
	</table>
	<section>
	<button id="btn_book_insert" class="bz-button">도서정보 새로입력</button>
	<button id="btn_list" class="bz-button">리스트</button>
	</section>
	

	
</body>
</html>