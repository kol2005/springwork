package com.biz.bok.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.bok.config.DataGoConfig;
import com.biz.bok.domain.BokDetailVO;
import com.biz.bok.domain.BokSearchDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BokDetailService {

	private final String bok_url = "http://www.bokjiro.go.kr/openapi/rest/gvmtWelSvc";
		
	public String getQueryHeader(String servId ) {
		String queryString = bok_url;
		
		queryString += "?crtiKey=" + DataGoConfig.DATA_GO_AUTH;				//	인증키
		queryString += "&callTp=D";						//	페이지타입
//		queryString += "&pageNo=";				//	페이지시작위치
//		queryString += "&numOfRows=";				//	출력건수
		queryString += "&servId=" + servId;			//	검색분류

		log.debug("쿼리문자열 : " + queryString);
		return queryString;
	}
	
	public BokDetailVO getRestResult(String servId) {
		
		// xml을 data로 변환할때 사용할 객체(도구)
		ResponseEntity<BokDetailVO> result = null;
		
		// RestTemplate를 사용하여 api에 보낼 URI를 생성
		URI restURI = null;
		
		// 생성된 URI를 api서버에 보내서 데이터를 수신할 객체(도구)
		RestTemplate restTemp = new RestTemplate();
		//ParameterizedTypeReference<List<BokListVO>> paramType 
		//= new ParameterizedTypeReference<List<BokListVO>>() {
		//};
		try {
			restURI = new URI(this.getQueryHeader(servId));
			// restURI를 서버에 보내서 수신된 xml형 문자열을
			// wantedList 클래스에 선언된 형식에 맞춰서 객체로 만들어라
			result = restTemp.exchange(restURI, HttpMethod.GET,null,BokDetailVO.class);
			
			log.debug("헤더 : " + restURI);
			log.debug("결과 : " + result.getBody());
			
			BokDetailVO bokDetail = (BokDetailVO)result.getBody();
			return bokDetail;
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
