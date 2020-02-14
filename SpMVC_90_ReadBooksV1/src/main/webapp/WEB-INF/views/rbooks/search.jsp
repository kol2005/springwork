<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>도서리스트 검색결과</title>
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
	$("#main-table tbody tr").click(function(){
		let b_code = $(this).attr("data-id")
		let b_name = $(this).attr("data-name")
		//테스트용
		//document.location.href = "${rootPath}/rbooks/insert" + b_code
		
		$("#rb_bcode",opener.document).val(b_code)
		$("#rb_bname",opener.document).val(b_name)
		
	
		//창 닫기
		window.close()
		//익스플로러 창 닫기
		window.open('about:blank','_self').self.close()
		//document.location.href = "${rootPath}/rbooks/insert/" + b_code
	})
	
})
</script>
</head>
<style>
header h1{
color: #297bff;
display: flex;
justify-content: center;
margin: 10px;
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
.navbar{
justify-content: center;
text-align: center;
}
.navbar-nav{
justify-content: center;
text-align: center;
}
.nav-item{
margin: 10px;
padding: 10px;
}

#main-table th:nth-of-type(1),#main-table td:nth-of-type(1){width: 10%;}
#main-table th:nth-of-type(2),#main-table td:nth-of-type(2){width: 30%;}
#main-table th:nth-of-type(3),#main-table td:nth-of-type(3){width: 20%;}
#main-table th:nth-of-type(4),#main-table td:nth-of-type(4){width: 15%;}
#main-table th:nth-of-type(5),#main-table td:nth-of-type(5){width: 10%;}
#main-table th:nth-of-type(6),#main-table td:nth-of-type(6){width: 10%;}

</style>
<header>
<h1>도서 리스트 검색</h1>
</header>
<body>

<div class="container">
	<table id="main-table" class="table table-bordered">
		<thead>
		<tr class="table-dark text-dark">
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>구입일자</th>
			<th>구입가격</th>
		</tr>
		</thead>
		
		<tr>
		<c:if test="${!empty BLIST}">
		<c:forEach items="${BLIST}" var="books">
			<tbody>
			<tr data-id="${books.b_code}" data-name="${books.b_name}" class="books-l table-active">
				<td class="books-list">${books.b_code}</td>
				<td class="books-list">${books.b_name}</td>
				<td class="books-list">${books.b_auther}</td>
				<td class="books-list">${books.b_comp}</td>
				<td class="books-list">${books.b_year}</td>
				<td class="books-list">${books.b_iprice}</td>
			</tr>
			</tbody>
		</c:forEach>
		</c:if>
		</tr>
	</table>

</div>



</body>
</html>