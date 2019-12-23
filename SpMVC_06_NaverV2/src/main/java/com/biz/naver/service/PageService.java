package com.biz.naver.service;

import org.springframework.stereotype.Service;

import com.biz.naver.domain.PageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PageService {

	private long listPerPage = 10; // 리스트 개수
	private long pageCount = 5; // 페이지 개수
	
	public void setListPerpage(long listPerpage) {
		this.listPerPage = listPerpage;
	}
	
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	
	/*
	 * 최소한의 조건으로 페이지를 계산하기 위한 method
	 * 전체데이터 개수와 현재 선택된 페이지번호만 매개변수로 받아서
	 * 페이지 정보를 만들어내기
	 */
	public PageDTO makePageNation(long totalCount, long currentPageNo) {
		
		// 데이터가 없으면 중단
		if(totalCount < 1) return null;
		
		// (전체데이터 + 보여질리스트 -1) / 보여질리스트
		long finalPageNo = (totalCount + (listPerPage - 1)) / listPerPage;
		
		// naver는 페이지를 검색할때 1000페이지가 넘어가면 오류를 보낸다
		//finalPageNo = finalPageNo > 1000 ? 1000 : finalPageNo; // 3항연산자
		//if(finalPageNo > 1000)finalPageNo = 1000; //if문을 이용한 연산
		
		// currentPageNo(현재 보고있는 페이지)가 마지막 페이지보다 크면
		if(currentPageNo > finalPageNo) currentPageNo = finalPageNo;
		
		// currentPageNo가 1보다 작으면
		if(currentPageNo < 1) currentPageNo = 1;
		
		// 이전, 이후를 계산하기 위해서 현재 페이지 번호가
		// 첫페이지인가, 마지막페이지 인가를 검사해서 flag를 세팅
		// bYes = 3 == 3;
		boolean isNowFirst = currentPageNo == 1;
		boolean isNowFinal = currentPageNo == finalPageNo;
		
		// 하단에 리스트로 보여줄 페이지 계산
		// cur : 3이면 1 ~ 5 , cur 10이면 8 ~ 12까지 이런식으로 보여주기 위한 계산
		long startPageNo = ((currentPageNo - 1) / this.pageCount) * this.pageCount + 1;
		
		long endPageNo = startPageNo + this.pageCount - 1;
		
		if(endPageNo > finalPageNo)endPageNo = finalPageNo;
		
		PageDTO pageDTO = PageDTO.builder()
				.totalCount(pageCount)
				.pageCount(this.pageCount)
				.listPerPage(this.listPerPage)
				.firstPageNo(1)
				.finalPageNo(finalPageNo)
				.startPageNo(startPageNo)
				.endPageNo(endPageNo)
				.currentPageNo(currentPageNo)
				.build();
		
		if(isNowFirst) pageDTO.setPrePageNo(1);
		else pageDTO.setPrePageNo((currentPageNo-1) < 1 ? 1 : currentPageNo - 1);
			if(isNowFinal) pageDTO.setNextPageNo(finalPageNo);
			else pageDTO.setNextPageNo((currentPageNo + 1 ) > finalPageNo ? finalPageNo : currentPageNo + 1);
		
		
		return pageDTO;
	}
}
