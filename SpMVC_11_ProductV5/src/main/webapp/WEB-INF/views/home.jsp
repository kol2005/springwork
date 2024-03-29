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
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${rootPath}/css/pro-main.css?ver=2019-12-23">

<script>
var rootPath = "${rootPath}"
var bStart = 0
</script>
<script src="${rootPath}/js/pro-main.js?ver=2019-12-23"></script>
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
			<div id="p_List" class="col-lg-4 col-md-4 col-sm-10"><%@ include
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
							<div class="valid-feedback" ></div>
							<div class="invalid-feedback" >과세 체크</div>
						</label>
					</div>

					<div class="form-group">
						<label for="p_oprice">매출가격</label> <input type="text"
							class="form-control" placeholder="매출가격을 입력하세요" id="p_oprice"
							name="p_oprice" required>
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">매출가격은 반드시 입력하세요</div>
					</div>
<%
/*
input type="text"
파일을 업로드 수행하기 위한 컨트롤 요소
multiple="multiple" : 여러개의 파일을 동시에 업로드 가능
accept="" : 특정한 성질의 파일만 올리고 싶을때
accept="image/*" : 이미지 관련 파일들
accept="text/plain" : text 파일만(*.txt)
accept="text/html" : text파일중에 *.html
accept="video/*" : 동영상 관련 파일

accept="application/vnd.ms-excel" : excel 파일만
accept="*.xls|*.xlsx" : excel 파일
*/
%>
<div class="form-group">
<input type="hidden" name="p_file" id="p_file" >
<label>대표이미지</label>
<input type="file" class="form-controller" name="u_file" id="u_file" accept="image/*">
</div>


<div class="form-group">
<input name="p_file" id="p_file" >
<label>보조이미지</label>
<input type="file" class="form-controller" name="u_files" id="u_files" multiple="multiple" accept="image/*">
</div>


<div class="form-group main-img-box">
<img src="${rootPath}/files/noimage.png" id="p_image" width="90%" />
	<div class="img-menu">
	<div class="img-text" id="pro-img-delete">
	<i class="fa fa-trash"></i></div>
	<div class="img-text img-view" id="pro-img-search">
	<i class="fa fa-search"></i></div>
	</div>
</div>
					<button type="reset" class="btn btn-warning">새로작성</button>
					<button type="submit" class="btn btn-primary">저장</button>
				</form>

			</section>
			<div id="p_sub_list" class="col-lg-4 col-md-5 col-sm-10">보조정보</div>
		</article>
	</section>
	<footer class="container-fluid bg-primary">
		<address class="text-center text-white">Copy Right &copy;
			씨에이엘엘오알.컴</address>
	</footer>

</body>
</html>