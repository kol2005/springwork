<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개돼지 축사</title>
<style>
*,html,body{
margin:0;
padding: 0;
}
/* 
header : tag 이름
{} : 모양에 대한 여러가지 속성 지정
*/
header {
background-color: #006603; /* box의 바탕색을 지정 */
color : #FFFFFF; /* header box 내의 문자열의 글자색을 지정 */
margin:0;
padding: 0.2rem;

}
img#i1 {
display: block;
margin: 0px auto;
}
img {
display: block;
margin: 0px auto;
}
aside#s1 {
text-align:left;
padding:0;
margin:0;
background-image: url(3.jpg); /*이미지 경로*/
width: 25%; /*가로 폭*/
height: 25%; /* 세로폭*/
overflow: hidden; /* 범위를 넘엇을시 넘는 영역 숨김*/
background-position: 0 0; /* 시작위치*/
background-repeat: no-repeat; /* 배경화면 반복*/
background-attachment: fixed; /* 배경화면 스크롤시 고정*/
background-size: cover; /* 배경화면 비율유지*/
position: relative; /* 위치지정*/
overflow-y: auto; /*스크롤*/

}
h1{
text-align:center;
font-size: 30pt;
}
ul{
/* display : flex 
box model tag의 속성을
inline-box 속성으로 변경하는 것
*/
display: flex; 
list-style: none; /* list의 머릿글 제거 */
width: 50%;
}
li{
width: 150px;
margin-right: 30px;
background-color: #FE2EC8;
font-size: 15pt;
}
/* 태그만 시작하면 본문에 있는 모든 tag에 적용*/
a {
text-decoration: none; /* a tag에 적용되어서 밑줄을 없애는 용도 */
padding: 10px;
}
/*
a:hover 액션을 지정하는데
nav tag 내에있는 a tag에만 액션을 지정하라
*/
nav a:hover {
	font-weight: bold; /* 글자모양을 bold체로 변경 */
	font-style: italic; /* 글자모양을 이텔릭체로 변경 */
	
}

p {
background-color: cyan;
}

/* 이문서에 id가 p1으로 지정된 tag에 스타일을 지정하라 
p#p1 또는 #p1 형식으로 지정해도 된다 */
#p1{
font-size: 50pt;
background-color: blue;
color: white;
}
#p2{
font-size: 50pt;
}
/* 이문서에 class가 pc 로 지정된 tag에 스타일을 지정하라 
p.pc 또는 .pc 형식으로 지정해도 된다. */
p.pc{
background-color: red;
color: white;
}

</style>
</head>
<body>
	<header>
		<img id="i1" src="${rootPath}/resources/img/57d569d49f667a7e7e04a805f3df967f.png" width=400px >
	</header>
	<aside id="s1">사이드메뉴1</aside>
	<aside id="s1">사이드메뉴1</aside>
	<aside id="s1">사이드메뉴1</aside>
	<aside id="s1">사이드메뉴1</aside>
	<nav>
		<ul>
			<li><a href="#">ㄱㄷㅈ리스트</a></li>
			<li><a href="#">ㄱㄷㅈ검색</a></li>
			<li><a href="#">축사 입장</a></li>
			<li><a href="#">ㄱㄷㅈ 가입</a></li>
		</ul>
		<img src="${rootPath}/resources/img/maxresdefault (1).jpg">
		<img src="${rootPath}/resources/img/16e8b1b37f51349a5.gif">
	</nav>
	<section>
		<article>
			<p id="p0"><font size=50pt color="blue" face=궁서>멍멍 꿀꿀 ♡♡ ♥♥</font></p>
			
			
			<p id="p1">사퇴하세요</p>
			<img src="${rootPath}/resources/img/21130D4A57F8B0CA2D.png" onmouseover="this.src='${rootPath}/resources/img/thingking.jpg'" onmouseout="this.src='${rootPath}/resources/img/21130D4A57F8B0CA2D.png'" width=1000px>
			<img src="${rootPath}/resources/img/0cd0ebc67e802ab546fc3b5259cff743.jpg" onmouseover="this.src='${rootPath}/resources/img/thingking.jpg'" onmouseout="this.src='${rootPath}/resources/img/0cd0ebc67e802ab546fc3b5259cff743.jpg'" width=1000px>
			<p id="p2">사람을 화나게 하는 방법은 두 가지가 있는데 첫 번째는 말을 하다 마는 것이고 두 번째는...</p>
			<p id="p3" class="pc">여기는 p3 입니다</p>
			<p id="p4" class="pc">여기는 p4 입니다</p>
			<p id="p5" class="pc">여기는 p5 입니다</p>
			<p><a href="https://naver.con/">네이버 바로가기</a>
			<a href="https://daum.net/">다음 바로가기</a>
		</article>
	</section>
	<footer>
		<address>CopyRight &copy; @naver.com</address>
	</footer>


</body>
</html>