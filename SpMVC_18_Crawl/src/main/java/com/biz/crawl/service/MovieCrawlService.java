package com.biz.crawl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.persistence.NaverDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MovieCrawlService {

	/*
	 * 네이버 현재 상영작 리스트에서 
	 * 영화 제목, 이미지, 순위를 가져오기 위해서
	 * url, title이 들어있는 tag, 
	 * 		image가 들어있는 tag,
	 * 		rankList를 가져오기 위한 tag 묶음 정보를 변수로 선언
	 */
	private final String naverMovieURL = "https://movie.naver.com/movie/running/current.nhn";
	private final String mTitleTag = "dt.tit a";
	private final String mImageTag = "div.thumb a img";
	private final String rankListTag = "dl.lst-dsc";
	private final NaverDao nDao;
	
	public List<NaverMovieVO> selectAll(){
		return nDao.selectAll();
	}
	
	/*
	 * fixedRade : 바로 이전 스케줄링이 시작된 이후에 다시 시작할 시간
	 * fixedDelay : 바로 이전 스케줄링이 종료된 이후 다시 시작할 시간
	 */
//	@Scheduled(fixedRate = 100000)
	@Scheduled(fixedDelay = 100000)
	/*
	 * Unix 시스템에서는 일정한 시간 (년,월,일,시,분,초)를 지정해서
	 * 어떤 일을 정기적으로 수행할때
	 * cron tab 이라는 기능을 이용해서 작업을 지정할수 있다
	 * 초, 분, 시, 일, 월, 요일, 년
	 */
	//@Scheduled(cron = "0 30 1 * * *")
	public void naverMovieGet() {
		List<NaverMovieVO> naverList = this.movieRankGet();
		nDao.deleteAll();
		nDao.insertAll(naverList);
		//for(NaverMovieVO vo : naverList) {
		//	nDao.insert(vo);
		//}
	}
	
	public List<NaverMovieVO> movieRankGet() {
		// URL에 해당하는 html 페이지코드를 가져오기
		// Document 라는 클래스에 담기
		// jsoup Document를 사용하여
		// DOM 형식의 Document를 만든다.
		Document naverMovieDoc = null;
		
		try {
			naverMovieDoc = Jsoup.connect(naverMovieURL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DOM rankListTag문자열을 기준으로 리스트 추출
		Elements rankList = naverMovieDoc.select(rankListTag);
		
		// DOM 에서 imageTag 문자열을 기준으로 리스트 추출
		Elements imgList = naverMovieDoc.select(mImageTag);
		
		// DOM titleTag 문자열을 기준으로 리스트 추출
		Elements titleList = naverMovieDoc.select(mTitleTag);
		
		// JDK 1.7 이상에서는 생성자 Generic은 생략 가능
		List<NaverMovieVO> naverList = new ArrayList();
		
		// rankList box들 중에 상위 1부터 10번까지만 가져오기 수행
		for(int i = 0 ; i< 10 ; i++) {
			
			// dt.tit a에 담긴 text를 추출학리 = 영화제목
			String title = titleList.get(i).text();
			// href 속성값 ( 디테일 페이지 , 영화 자세히보기 ) 뽑아오기
			// dt.tit a tag의 href 속성값을 추출 = 영화 자세히 보기
			// https://movie.naver.com/movie/bi/mi/basic.nhn?code=181925
			String detailURL = "https://movie.naver.com" + titleList.get(i).attr("href");
			
			// div.thumb a img 의 src 속성값을 추출 = 영화 이미지 URL
			String imgURL = imgList.get(i).attr("src");
			
			naverList.add(NaverMovieVO.builder()
						.m_rank(i+1)
						.m_title(title)
						.m_detail_url(detailURL)
						.m_image_url(imgURL)
						.build());
			
			log.debug("영화 제목 : " + title);
		}
		return naverList;
	}
}
