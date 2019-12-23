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
$(function(){
	/*
	if(class.content-body == click){
		....실행하라
	}
	
	click(function(){ } )
	익명함수(무명함수) click event가 발생했을때 call(호출)되어
	실행될 코드들의 묶음
	call back function() 라고 부른다
	*/
	$("#th-date").click(function(){
		alert("날짜 머리글이 클릭되었음")
	})
	$(".content-body").click(function(){
		// $(this) : 현재 클릭된 요소, tag의 모든 정보
		let id = $(this).attr("data-id")
		let auth = $(this).attr("data-auth")
		
		//alert(id+"\n"+auth)
		
		document.location.href = "${rootPath}/memo/view?id="+id
	})
	
})

</script>

</head>
<body>
<%
/*
css, js 파일을 만들고 jsp, html 에서 import를 하여 사용할 경우
해당 파일을 변경(수정)했을 경우 tomcat이 해당파일이 변경된 것을
알지 못하는 현상이 자주발생을 한다.
이럴경우 브라우저의 방문기록을 삭제하면 변경된 내용이 반영이 되는데
상당히 불편하고 만약 배포된 상태에서 불특정 다수가 웹을통해 접속했을경우
사용자에게 일일이 브라우저 방문기록을 삭제해달라 요청할수도 없다

그래서 대안으러 파일이름을 변경하여 서버를 reloading하는 방법이 있는데
이방법도 계속해서 파일이름을 변경해야하는 상황이 좋지 않다

현재 많은 App에서 사용하는 방법으로 
파일이름 뒤에 dumy query를 부착하여 마치 파일이름을 변경하는 것처럼
tomcat에게 알린다
list-table.css 파일 뒤에
?ver-*** 라는 query를 부착하여 버전 숫자를 변경하고
tomcat을 reloading 해주면 대부분의 문제가 해결된다

따라서 css,js 파일의 코드를 변경한 후에는
ver 숫자를 지금과 다른 값으로 변경하고 tomcat을 reloading 하자
*/
%>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/list-table.css?ver=2019-12-02" >
	<table>
		<tr>
			<th>SQ</th>
			<th id="th-date">작성일</th>
			<th>작성시각</th>
			<th>작성자</th>
			<th>카테고리</th>
			<th>제목</th>
		</tr>
		<c:choose>
			<c:when test="${empty MEMO_LIST eq NULL}">
				<tr>
					<td colspan="6">메모가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${MEMO_LIST}" var="memo" varStatus="index">
					<tr class="content-body" data-id="${memo.m_seq}" data-auth="${memo.m_auth}">
						<td>${index.count}</td>
						<td>${memo.m_date}</td>
						<td>${memo.m_time}</td>
						<td>${memo.m_auth}</td>
						<td>${memo.m_cat}</td>
						<td>${memo.m_subject}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>