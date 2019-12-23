<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
p#insert{
margin: 20px;
}
</style>
<script>
$(function() {
	$(".content-body").click(function(e){
		let p_code = $(this).attr("id")
		document.location.href="${rootPath}/product/view?p_code="+p_code
	})
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-product-header.jspf" %>
<section>
<%@ include file="/WEB-INF/views/product/list-body.jsp" %>
</section>
</body>
</html>