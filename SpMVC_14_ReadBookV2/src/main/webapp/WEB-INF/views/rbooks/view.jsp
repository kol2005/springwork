<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<script>
$(function(){
	
	let star = "${RBOOK.rb_star}"
	if(star == "") star = 1
	else star = parseInt(star)
	star = star * 10
	$('span.star-red').css("width",star + "%")
	
	$("button").click(function(){
		let btn_id = $(this).attr("id")
		let url = "${rootPath}/rbook/"
		
		if(btn_id == "btn-update"){
			url += "update/${RBOOK.rb_seq}"
		}else if(btn_id == "btn-delete"){
			if(!confirm("독서록을 삭제할까요")){
				return false
			}
			url += "delete/${RBOOK.rb_seq}"	
		}else if(btn_id == "btn-list"){
			url += "list"
		}
		document.location.href = url
	})
	
})
</script>
<style>

.input-box{
display: flex;
width: 80%;
margin: 5px auto;
}

.input-box input{
color: black;
border: none;
border-bottom: 1px solid rgb(52,152,219);
display: block;
font-size: 0.9rem;
width: 100%;
padding: 8px;
}

#rb_bcode{
width:50%;
margin-right: 5px;
}

article{
display: flex;
flex-flow: wrap;
}

div{
display: inline-block;
width: 70%;
padding: 5px 16px;
margin: 5px;
background-color: #eee;
}

div.title-box{
width: 25%;
background-color: #ccc;
text-align: right;
}

span.star-box{
width: 100px;
}

span.star-box,span.star-red {
display: inline-block;
height: 20px;
overflow: hidden;

background: url("${rootPath}/image/star.png") no-repeat;

/* 배경이미지를 width: 자동 height 40px */
background-size: 100px 40px; 
}

span.star-red {
/* 배경이미지를 채울때 왼쪽 아래 꼭짓점을 기준으로 배치*/
background-position: left bottom;
line-height: 0;
vertical-align: top;
width: 50%;
}
div.text-box{
width: 100%;
}

</style>
</head>
<body>
<header>
	<h2>MY READ BOOK</h2>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	
<section>

<%@ include file="/WEB-INF/views/books/book-view.jsp" %>

	<article>
		<div class="title-box">읽은때</div>
		<div>${RBOOK.rb_date},${RBOOK.rb_stime} 부터 ${RBOOK.rb_rtime} 시간동안 읽음</div>
		<div class="title-box">한줄평</div>
		<div>${RBOOK.rb_subject},
		<span class="star-box">
		<span class="star-red"></span>
		</span></div>
		<div class="text-box">${RBOOK.rb_text}</div>
	</article>
	<article>
		<button id="btn-update" type="button" class="flex-right biz-blue">수정</button>
		<button id="btn-delete" type="button" class="biz-red">삭제</button>
		<button id="btn-list" type="button" class="biz-orange">리스트보기</button>
	</article>
</section>
<%@ include file="/WEB-INF/views/rbooks/list-body.jsp" %>
	
</body>
</html>