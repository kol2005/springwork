package com.biz.pet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoPetVO {
	
	private String apiSid;		//	데이터번호
	private String apiDongName;	//	동물병원의 이름
	private String apiNewAddress;//	도로명주소
	private String apiOldAddress;//	지번주소
	private String apiTel;		//	대행업소의 연락처
	private String apiLat;		//	위도
	private String apiLng;		//	경도
	private String apiRegDate;	//	데이터기준일
	
}

//		private String resultCode;	//	결과코드
//		private String resultMsg;	//	결과메세지
//		private String pageNo;		//	페이지 수
//		private String pageIndex;	//	페이지 시작 번호
//		private String numOfRows;	//	한 페이지의 결과 수
//		private String totalCount;	//	전체 결과 수
