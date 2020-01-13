<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
.modal {
	display: none;
	position: fixed;
	z-index: 10;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal form{
position: relative;
width: 30%;
padding: 10px;
border: 1px solid #888;
margin: auto;
background-color: #fefefe;
animation-name: form-ani;
animation-duration: 10s;
animation-fill-mode: forwards;

/* 구글,사파리 */
-webkit-animation-name: form-ani;
-webkit-animation-duration: 10s;
-webkit-animation-fill-mode: forwards;

/* 파이어폭스 */
-moz-animation-name: form-ani;
-moz-animation-duration: 10s;
-moz-animation-fill-mode: forwards;

/* 익스 */
-ms-animation-name: form-ani;
-ms-animation-duration: 10s;
-ms-animation-fill-mode: forwards;

/* 오페라 */
-o-animation-name: form-ani;
-o-animation-duration: 10s;
-o-animation-fill-mode: forwards;
}
/*
animation 실행하는 css
*/
@keyFrames form-ani{
from{
	top: -300px;
	opacity: 0;
	
}
to{
top: 200px;
opacity: 1;
}

}

@-webkit-keyFrames form-ani{
from{
	top: -300px;
	opacity: 0;
	
}
to{
top: 200px;
opacity: 1;
}

}

span.modal-close{
color: white;
float: right;
font-size: 30px;
font-weight: bold;
}

span.modal-close:hover{
color: #000;
cursor: pointer;
}
</style>
<script type="text/javascript">
$(function(){
	
	$("span.modal-close").click(function(){
		$("#myModal").css("display","none")
	})
	
})
</script>
<div id="myModal" class="modal">
<div>
<span class="modal-close">&times;</span>
</div>

	<form action="${rootPath}/member/login" method="POST">
		<div>
		<input type="text" name="user_id" placeholder="사용자 아이디">
		</div>
		<div>
		<input type="password" name="password" placeholder="비밀번호">
		</div>
		<div>
		<button id="btn-login">로그인</button>
		</div>
	</form>

</div>