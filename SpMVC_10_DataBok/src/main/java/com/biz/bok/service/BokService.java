package com.biz.bok.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.bok.config.DataGoConfig;
import com.biz.bok.domain.BokListVO;
import com.biz.bok.domain.BokSearchDTO;
import com.biz.bok.domain.WantedList;

import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BokService {

	private final String bok_url = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc";
	private final String bok_list_url = "/NationalWelfarelist";
	private final String bok_detail_url = "/NationalWelfaredetailed";
	
	public String getQueryHeader(BokSearchDTO bokDTO) {
		String queryString = bok_url;
		
		
		
//		if(bokDTO.getCallTp().equalsIgnoreCase("L")) {
//			queryString += bok_list_url;
//		}else {
//			queryString += bok_detail_url;
//		}
		queryString += "?crtiKey=" + DataGoConfig.DATA_GO_AUTH;				//	인증키
		queryString += "&callTp=" + bokDTO.getCallTp();						//	페이지타입
		queryString += "&pageNo=" + bokDTO.getPageNo();						//	페이지시작위치
		queryString += "&numOfRows=" + bokDTO.getNumOfRows();				//	출력건수
		queryString += "&srchKeyCode=" + bokDTO.getSrchKeyCode();			//	검색분류
		
		String searchWrd = "";
		try {
			searchWrd = URLEncoder.encode(bokDTO.getSearchWrd(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		queryString += "&searchWrd=" + searchWrd;				//	검색어
		
		queryString += "&lifeArray=" + bokDTO.getLifeArray();				//	생애주기
		queryString += "&charTrgterArray=" + bokDTO.getCharTrgterArray();	//	대상특성
		queryString += "&obstKiArray=" + bokDTO.getObstKiArray();			//	장애유형
		queryString += "&obstAbtArray=" + bokDTO.getObstAbtArray();			//	장애정도
		queryString += "&trgterIndvdlArray=" + bokDTO.getTrgterIndvdlArray();//	가구유형
		queryString += "&desireArray=" + bokDTO.getDesireArray();			//	욕구

		log.debug("쿼리문자열 : " + queryString);
		return queryString;
	}
	
	public List<BokListVO> getRestResult(BokSearchDTO bokDTO) {
		
		// xml을 data로 변환할때 사용할 객체(도구)
		ResponseEntity<WantedList> result = null;
		
		// RestTemplate를 사용하여 api에 보낼 URI를 생성
		URI restURI = null;
		
		// 생성된 URI를 api서버에 보내서 데이터를 수신할 객체(도구)
		RestTemplate restTemp = new RestTemplate();
		//ParameterizedTypeReference<List<BokListVO>> paramType 
		//= new ParameterizedTypeReference<List<BokListVO>>() {
		//};
		try {
			restURI = new URI(this.getQueryHeader(bokDTO));
			// restURI를 서버에 보내서 수신된 xml형 문자열을
			// wantedList 클래스에 선언된 형식에 맞춰서 객체로 만들어라
			result = restTemp.exchange(restURI, HttpMethod.GET,null,WantedList.class);
			
			log.debug("헤더 : " + restURI);
			log.debug("결과 : " + result.getBody());
			
			// 실제 데이터가 들어 있는 body만 추출
			// body에는 WantedList 클래스 형 데이터가 들어있다
			WantedList wantedList = (WantedList)result.getBody();
			
			// servList값을 추출하여 필요한 데이터 리스트만 뽑기
			List<BokListVO> bokList = wantedList.servList;
			
			for(BokListVO v : bokList) {
				log.debug("요소:" + v.toString());
			}
			return bokList;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 검색에 필요한 기본변수들 셋팅
	public BokSearchDTO getDefaultSearch() {
		return BokSearchDTO.builder()
				.callTp("L")
				.pageNo("1")
				.numOfRows("10")
				.build();
	}
}
