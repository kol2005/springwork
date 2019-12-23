package com.biz.naver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * pagenation의 여러가지 설정값을 저장하고
 * 설정값을 변경하여 쉽게 페이지리스트를 그릴수 있는 정보를
 * 저장할 칼럼
 * 
 * 전체 데이터의 개수 : 페이지수등을 계산
 * 현재 페이지에 보여질 개수
 * 현재 페이지 하단에 보여질 페이지의 개수
 * 
 * 보여지는 페이지의 끝번호 : 계산후
 * 보여지는 페이지의 첫번호 : 계산후
 * 
 * 처음페이지 : "처음"으로 가기를 클릭했을때 보여질 페이지 번호(1페이지)
 * 마지막페이지 : "끝"으로 가기를 클릭했을때 전체 데이터 개수등으로 계산
 * 
 * 이전페이지
 * 이후페이지
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PageDTO {

	private long totalCount; //전체 데이터 개수
	
	private long listPerPage; // 한페이지에 보여질 데이터 개수
	private long pageCount; // 현재페이지 하단에 보여질 페이지번호 리스트 개수
	
	private long firstPageNo; // 전체데이터의 첫페이지 번호(일반적으로 1)
	private long finalPageNo; // 전체데이터의 마지막 페이지 번호(계산결과)
	
	private long prePageNo; // 이전페이지
	private long startPageNo; // 보여지는 리스트의 시작페이지 번호
	
	private long nextPageNo; //다음페이지
	private long endPageNo; //보여진느 리스트의 끝 번호
	
	private long currentPageNo; // 현재 선택된 페이지 번호
	
}
