<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□나의 JSP 페이지□□□</title>
</head>
<body>
	<section>

		<p>서비스 이용 및 신청방법 : ${detail.applmetList.servSeDetailNm}
		<p><img src="${detail.applmetList.servSeDetailLink}" alt="신청방법" />
		<p>문의처 : ${detail.inqplCtadrList.servSeDetailNm}
		( ${detail.inqplCtadrList.servSeDetailLink} )
		<p>사이트명 : <a href="${detail.inqplHmpgReldList.servSeDetailLink}">
				${detail.inqplHmpgReldList.servSeDetailNm}</a>
		<p>서식/자료명 : <a href="${detail.basfrmList.servSeDetailLink}">
				${detail.basfrmList.servSeDetailNm}</a>
		<p>근거법령명 : <a href="${detail.baslawList.servSeDetailLink}">
				${detail.baslawList.servSeDetailNm}</a>
	</section>

</body>
</html>