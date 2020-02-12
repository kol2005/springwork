<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="BBS" items="${BBS_SUB}" varStatus="index">
	<tr class="bbs_tr" data-id="${BBS.bbs_id}">
		<td>&nbsp;&nbsp;re : ${index.count}</td>
		<td>${BBS.bbs_writer}</td>
		<td>${BBS.bbs_date}</td>
		<td>${BBS.bbs_time}</td>
		<td>&nbsp;${BBS.bbs_subject}</td>
	</tr>

</c:forEach>
