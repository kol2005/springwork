<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>

*{
	margin:0;
	padding:0;
	box-sizing: border-box;
}

.join-form{
	width:400px;
	padding: 40px;
	background: blue;
	text-align: center;
	z-index: 10;
	
	border-radius: 20px;
	box-shadow: 12px 12px 2px 1px rgba(0, 0, 255, 0.2);
	margin : 20px auto;
}

.join-form h2 {
	color:white;
	font-weight: 500;
}

.join-form h3 {
	color:white;
	font-weight: 300;
	background-color: red;
	border-radius: 20px;
}

.join-form input{
	
	background: none;
	margin:20px auto;
	text-align: center;
	border: 2px solid #3498db;
	
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color:white;
	
	border-radius: 25px;
	transition: 0.2s;
}

.join-form button{
	border: 2px solid #2ECC71;
	padding: 14px 40px;
	background: none;
	display: block;
	margin: 20px auto;
	padding: 14px 40px;
	
	outline: none;
	color: white;
	
	border-radius: 25px;
	cursor: pointer;
}

.join-form input:focus{
	width:280px;
	border-color: #2ecc71;
	
}

.join-form button:hover{
	background-color: #2ecc71;
	
}

</style>
<form method="POST" action="${rootPath}/member/join" class="join-form">
<h2>회원가입</h2>

<input type="text" name="u_id" placeholder="사용자 ID">
<input type="password" name="u_password" placeholder="비밀번호">
<input type="password" name="u_re_password" placeholder="비밀번호 확인">
<button>회원가입</button>
</form>

