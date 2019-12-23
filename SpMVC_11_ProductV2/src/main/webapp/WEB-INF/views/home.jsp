<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
div {
	margin: 5px;
}

div.row {
	margin: 0 auto;
}

div#p_List {
	height: 600px;
	overflow: auto;
}
#p_image{
position: relative;
}
#p_image:hover{
background-color: rgba(0,0,0,0.3);

}
</style>
<script>
$(function(){
	
	$("#p_image").click(function(){
		if(confirm("이미지를 삭제할까요")){
			let p_code = $("#p_code").val()
			document.location.href="${rootPath}/imgDelete?p_code=" + p_code 
		}
	})	
	
})
</script>
</head>
<body>
	<header class="container-fluid jumbotron text-center bg-success">
		<h3>상품정보관리</h3>
		<p>대한 쇼핑몰 상품정보 관리자 화면</p>
	</header>
	<nav class="container-fluid navbar navbar-expand-sm bg-dark">
		<ul class="navbar-nav">
			<li><a class="navbar-brand nav-link" href="#">홈</a></li>
			<li class="nav-item"><a class="nav-link" href="#">상품등록</a></li>
			<li class="nav-item"><a class="nav-link" href="#">재고관리</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">관리자</a>
			</li>
		</ul>
	</nav>
	<section class="container-fluid">
		<article class="row d-flex justify-content-center">
			<div id="p_List" class="col-lg-3 col-md-4 col-sm-10"><%@ include
					file="/WEB-INF/views/p-List.jsp"%></div>
			<section class="col-lg-3 col-md-4 col-sm-11">

				<form class="was-validated" method="POST" enctype="multipart/form-data" action="${rootPath}/input">
					<div class="form-group">
						<label for="p_code">상품코드</label> <input type="text"
							class="form-control" placeholder="상품코드를 입력하세요" id="p_code"
							name="p_code" >
						<div class="valid-feedback">Valid.</div>
					</div>

					<div class="form-group">
						<label for="p_name">상품이름</label> <input type="text"
							class="form-control" placeholder="상품이름을 입력하세요" id="p_name"
							name="p_name" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">상품이름은 반드시 입력하세요</div>
					</div>

					<div class="form-group">
						<label for="p_iprice">매입가격</label> <input type="text"
							class="form-control" placeholder="매입가격을 입력하세요" id="p_iprice"
							name="p_iprice" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">매입가격은 반드시 입력하세요</div>
					</div>

					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" name="p_vat" value="1">과세
							<div class="valid-feedback"></div>
							<div class="invalid-feedback">과세 체크</div>
						</label>
					</div>

					<div class="form-group">
						<label for="p_oprice">매출가격</label> <input type="text"
							class="form-control" placeholder="매출가격을 입력하세요" id="p_oprice"
							name="p_oprice" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">매출가격은 반드시 입력하세요</div>
					</div>
<div class="form-group">
<input type="hidden" name="p_file" id="p_file">
<label></label>
<input type="file" class="form-controller" name="u_file" id="p_oprice">
</div>
<div class="form-group">
<img src="${rootPath}/files/noimage.png" id="p_image" width="200px" height="200px"/>
</div>
					<button type="reset" class="btn btn-warning">새로작성</button>
					<button type="submit" class="btn btn-primary">저장</button>
				</form>

			</section>
			<div class="col-lg-3 col-md-4 col-sm-10">보조정보</div>
		</article>
	</section>
	<footer class="container-fluid bg-primary">
		<address class="text-center text-white">Copy Right &copy;
			씨에이엘엘오알.컴</address>
	</footer>

</body>
</html>