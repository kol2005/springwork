<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="view-table">
	<tr>
		<th>받은 Email</th><td>${emailVO.to_email}</td>
		<th>받은 사람</th><td>${emailVO.to_name}</td>
	</tr>
	<tr>
		<th>보낸 Email</th><td>${emailVO.from_email}</td>
		<th>보낸 사람</th><td>${emailVO.from_name}</td>
	</tr>
	<tr>
		<th>보낸 날짜</th><td>${emailVO.send_date}</td>
		<th>보낸 시각</th><td>${emailVO.send_time}</td>
	</tr>
	<tr>
		<th>제목</th><td>${emailVO.subject}</td>
	</tr>
	<tr>
		<td>${emailVO.content}</td>
	</tr>
</table>
