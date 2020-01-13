<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="img_panel img_card" data-seq="${img.img_seq}" data-file="${img.img_file}">
		
		<c:if test="${empty img.img_file}">
		<img src="${rootPath}/images/main_sub.gif" width="100%" height="80%">
		</c:if>
		<c:if test="${!empty img.img_file}">
		<img src="${rootPath}/images/${img.img_file}" width="100%" height="80%">
		</c:if>
		<div class="img_title">
			<h4>${img.img_title}</h4>
		</div>
</div>