package com.biz.bok.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BokSearchDTO {

	private String crtiKey;				//	인증키
	private String callTp;				//	페이지타입
	private String pageNo;				//	페이지시작위치
	private String numOfRows;			//	출력건수
	private String srchKeyCode;			//	검색분류
	private String searchWrd;			//	검색어
	private String lifeArray;			//	생애주기
	private String charTrgterArray;		//	대상특성
	private String obstKiArray;			//	장애유형
	private String obstAbtArray;		//	장애정도
	private String trgterIndvdlArray;	//	가구유형
	private String desireArray;			//	욕구

}
