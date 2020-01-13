<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>
.img_list{
display: flex;
flex-wrap: wrap;
}
.img_view img{
width: 300px;
height: 300px;
margin: 5px;
}
</style>
<div class="img_list">
	<c:forEach items="${imgList}" var="img">
	<input type="hidden" name="img_file_upload_name" value="${img.img_file_upload_name}">
		<div class="img_view" data-id="${img.img_file_seq}">
			<img src="${rootPath}/images/${img.img_file_upload_name}">
		</div>
	</c:forEach>
</div>