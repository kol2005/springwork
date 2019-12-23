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
<script src="${rootPath}/js/jquery-3.4.1.js"></script>
<script>
	$(function() {
		$("#btn-insert").click(function() {
			document.location.href = "${rootPath}/memo/insert"
		})
	})
</script>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html, body {
	height: 100%;
}

body {
	width: 978px;
	display: flex;
	flex-flow: column nowrap;
	margin: 0 auto;
}

header {
	background: #ccc;
	text-align: center;
	padding: 0.8rem;
}

footer {
	flex: 0 0 auto;
	background: green;
	color: white;
	text-align: center;
	padding: 0.2rem;
}

section#main-body {
	flex-grow: 1;
	flex-shrink: 0;
	flex-basis: auto;
	background-color: #ddd;
	display: flex;
}

section#main-body article {
	flex: 5;
}

section#main-body aside {
	border: 1px solid blue;
	background-color: white;
	padding: 16px;
	border-radius: 10px;
}

section#main-body ul {
	list-style: none;
	margin-left: 16px;
}

section#main-body li a {
	/* a tag에 width, height 를 설정하기 위해서는
display를 block, inline-block 으로 설정해야 한다
*/
	display: inline-block;
	width: 100px;
	border-bottom: 1px solid blue;
	padding: 10px 16px;
	text-decoration: none;
}

section#main-body li a:hover {
	background-color: #ccc;
}

article.list {
	border: 1px solid red;
	height: 80%;
	overflow: auto;
}

div.b-box {
	display: flex;
	justify-content: center;
	align-item: center;
	padding: 0.8rem;
}

div.b-box button {
	background-color: orange;
	color: blue;
	font-weight: bold;
	padding: 8px 16px;
	border: 0px;
	border-radius: 5px;
}

div.b-box button:hover {
	background-color: #ddd;
}

div.s-box {
	width: 100%;
	border: 1px solid blue;
	margin-bottom: 5px;
}

div.s-box input {
	display: block;
	width: 90%;
	margin: 10px auto;
}

nav ul {
	list-style: none;
	background-color: blue;
	color: white;
	display: flex;
}

nav li:nth-child(2) {
	margin-left: auto;
}

nav li:nth-child(4) {
	margin-left: auto;
}

nav ul a {
	text-decoration: none;
	display: inline-block;
	color: inherit;
	padding: 8px;
	margin: 5px;
}
</style>
</head>
<body>
	<header>
		<h3>심플 메모장</h3>
	</header>
	<nav>
		<ul>
			<li><a href="${rootPath}/">홈으로</a>
			<li><a href="${rootPath}/">메뉴1</a>
			<li><a href="${rootPath}/">메뉴2</a> 
				<c:if test="${userDTO == null || userDTO.u_id == null}">
					<li><a href="${rootPath}/member/login">로그인</a>
					<li><a href="${rootPath}/user/join">회원가입</a>
				</c:if> <c:if test="${userDTO != null && userDTO.u_id != null}">
					<li><a href="${rootPath}/member/logout">로그아웃</a>
					<li><a href="${rootPath}/user/mypage">${userDTO.u_nick}</a>
				</c:if>
		</ul>
	</nav>
	<section id="main-body">
		<article>
			<div class="s-box">
				<form>
					<input type="text" name="search">
				</form>
			</div>
			<article class="list">
				<c:choose>
					<c:when test="${BODY == 'JOIN'}">
						<%@ include file="/WEB-INF/views/user/insert.jsp"%>
					</c:when>
					<c:when test="${BODY == 'LOGIN'}">
						<%@ include file="/WEB-INF/views/member/login.jsp"%>
					</c:when>
					<c:when test="${BODY == 'MEMO_WR'}">
						<%@ include file="/WEB-INF/views/memo/insert.jsp"%>
					</c:when>
					<c:when test="${BODY == 'MEMO_VI'}">
						<%@ include file="/WEB-INF/views/memo/view.jsp"%>
					</c:when>
					<c:otherwise>
						<%@ include file="/WEB-INF/views/memo/list.jsp"%>
					</c:otherwise>
				</c:choose>

			</article>
			<div class="b-box">
				<button id="btn-insert">메모작성</button>
			</div>
		</article>

		<aside>
			<ul>
				<li><a href="#">오늘할일</a></li>
				<li><a href="#">약속</a></li>
				<li><a href="#">중요메모</a></li>
			</ul>
		</aside>
	</section>
	<footer>
		<address>copyright &copy; 이메일</address>
	</footer>

</body>
</html>