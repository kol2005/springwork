<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 
col-xl : >= 1200px
col-lg : >= 992px
	col-lg-2 : 만약 width 992px보다 크면 2/12 만큼의 크기를 1개의 box로 설정
col-md : >= 768px
	col-md-4 :  width 992px 미만이고 768px이상이면 4/12 만큼의 크기를 1개의 box로 설정
col-sm : >= 576px
	col-sm-12 : width 768px 미만이고 576px 이상이면 12/12 가로방향 1칸짜리 box를 설정하라
	sm 보다 작은 화면일 경우는 sm 형식의 설정값이 유지
 -->
<div class="col-xl-2 col-md-4 col-sm-12">
	<div class="card">
		<div class="card-header">${NAVER.m_title}</div>
		<div class="card-body">
			<img src="${NAVER.m_image_url}" width="100%">
		</div>
		<div class="card-footer">
			<a href="${NAVER.m_detail_url}">자세히 보기</a>
		</div>
	</div>
</div>