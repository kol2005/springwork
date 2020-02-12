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

<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css"	rel="stylesheet">
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

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

<style>
header h1{
color: #297bff;
display: flex;
justify-content: center;
margin: 20px;
padding: 20px;
}

h1{
background-color: #ffdd57;
font-weight: bold;
}

th{
font-weight: bold;
}

#main-table {
justify-content: center;
width: 150%;
margin-left: -25%;
}

#main-table th:nth-of-type(1),#main-table td:nth-of-type(1){width: 10%;}
#main-table th:nth-of-type(2),#main-table td:nth-of-type(2){width: 30%;}
#main-table th:nth-of-type(3),#main-table td:nth-of-type(3){width: 20%;}
#main-table th:nth-of-type(4),#main-table td:nth-of-type(4){width: 15%;}
#main-table th:nth-of-type(5),#main-table td:nth-of-type(5){width: 10%;}
#main-table th:nth-of-type(6),#main-table td:nth-of-type(6){width: 10%;}

</style>
<header>
<h1>도서 리스트</h1>
</header>
<body>

<div class="container">
	<table id="main-table" class="table table-bordered">
		<tr class="table-dark text-dark">
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>구입일자</th>
			<th>구입가격</th>
		</tr>
	
		<tr>
		<c:if test="${!empty bookList}">
		<c:forEach items="${bookList}" var="books">
			<tr class="books-l table-active" onclick="bookinfo('${books.b_code}')">
				<td class="books-list">${books.b_code}</td>
				<td class="books-list">${books.b_name}</td>
				<td class="books-list">${books.b_auther}</td>
				<td class="books-list">${books.b_comp}</td>
				<td class="books-list">${books.b_year}</td>
				<td class="books-list">${books.b_iprice}</td>
			</tr>
		</c:forEach>
		</c:if>
		</tr>
	</table>
</div>

	<section>
	<button id="btn_book_insert" class="bz-button btn btn-success">도서정보 새로입력</button>
	<button id="btn_list" class="bz-button  btn btn-primary">리스트</button>
	</section>
	
</body>
</html>