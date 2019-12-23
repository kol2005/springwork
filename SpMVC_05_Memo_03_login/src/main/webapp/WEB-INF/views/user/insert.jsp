<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<style>
fieldset{
width: 70%;
margin: 20px auto;
border: 1px solid green;
border-radius: 10px;
}

legend{
font-weight: bold;
font-size: 20px;
}

input,textarea {
display: inline-block;
width: 90%;
padding: 8px;
margin: 5px;
border-radius: 20px;
}

input:focus,textarea:focus,button{
border: 2px solid blue;
outline: none;
}

div.cat-box{
width:90%;
padding:6px;
padding-top: 4px;
padding-buttom: 10px;
}
[type=radio],[type=checkbox]{
width:24px;
height: 24px;
position: relative;
margin-left: 15px;
top: 6px;
text-align: top;
}
</style>
</head>
<body>
<fieldset>
<legend>회원가입</legend>
<form:form modelAttribute="userDTO" autocomlete="on" class="user-form">
<form:input type="email" path="u_id" class="in-box" placeholder="이메일 주소를 입력하세요" /><br/>
<form:input type="password" path="u_password" class="in-box" placeholder="비밀번호를 입력하세요" /><br/>
<input type="password" id="re_password" placeholder="비밀번호를 한번 더 입력하세요">

<form:input path="u_name" class="in-box" placeholder="이름을 입력하세요" /><br/>
<form:input path="u_nick" class="in-box" placeholder="별명을 입력하세요" /><br/>
<form:input path="u_tel" type="number" class="in-box" placeholder="전화번호를 입력하세요" /><br/>

<div class="cat-box">
<form:checkboxes path="u_hobby" items="${HO_LIST}" itemLabel="h_name" itemValue="h_code" />
</div>

<button>저장</button>

</form:form>
</fieldset>
</body>
</html>