<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${files}" var="file">


<div class="sub-img-box">
	<img src="${rootPath}/files/${file.file_upload_name}" 
	width="500px" height="500px" class="sub-img"
		data-id = "${file.file_seq}"
		  data-name = "${file.file_origin_name}"
		   data-upload = "${file.file_upload_name}">
	
	<div class="img-menu">
		<span class="img-delete"
		data-id = "${file.file_seq}"
		  data-name = "${file.file_origin_name}"
		   data-upload = "${file.file_upload_name}">
		<i class="fa fa-trash"></i></span>
		<span class="img-view"
		 data-id = "${file.file_seq}"
		  data-name = "${file.file_origin_name}"
		   data-upload = "${file.file_upload_name}">
		   <i class="fa fa-search"></i></span>
	</div>
</div>

</c:forEach>