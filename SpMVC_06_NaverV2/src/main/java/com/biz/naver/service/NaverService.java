package com.biz.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.biz.naver.config.NaverConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverService {

	private final String naver_news_url = "https://openapi.naver.com/v1/search/news.json";
	private final String naver_book_url = "https://openapi.naver.com/v1/search/book.json";
	private final String naver_movie_url = "https://openapi.naver.com/v1/search/movie.json";
	
	public JSONArray strToJson(String strText) throws ParseException {
		
		JSONParser jParser = new JSONParser();
		JSONObject jObject = null;
		
		// (json형)문자열을 JSONObject로 변환하는 method
		jObject = (JSONObject) jParser.parse(strText);
		
		// items tag가 품고있는 데이터들을 Json배열 객체로 만들어 달라
		JSONArray jArray = (JSONArray) jObject.get("items");
		return jArray;
	}
	
	public JSONArray getNews(String cat, String search) {
		
		log.debug("서비스");
		
		URL url;
		HttpURLConnection httpConn;
		
		try {
			// naver에 보낼 query URL을 UTF-8 방식으로 인코딩 수행
			String queryText = "인공지능";
			
			queryText = URLEncoder.encode(search,"UTF-8");
			String queryURL = naver_news_url;
			if(cat.equalsIgnoreCase("NEWS")) {
				queryURL = naver_news_url;
			}else if(cat.equalsIgnoreCase("BOOK")) {
				queryURL = naver_book_url;
			}else if(cat.equalsIgnoreCase("MOVIE")) {
				queryURL = naver_movie_url;
			}
			queryText = queryURL + "?query=" + queryText;
			
			// queryText 문자열을 Http 프로토콜의 header를 작성
			url = new URL(queryText);
			
			// url 정보를 가지고 접속 통로를 생성하라
			httpConn = (HttpURLConnection) url.openConnection();
			
			// naver에 query를 수행하기 위해 정보를 설정(보내기)
			httpConn.setRequestMethod("GET");
			
			// id는 노출되면 안되기때문에
			// http body의 감춰진 영역에 값을 저장하여 보낸다
			httpConn.setRequestProperty("X-Naver-Client-Id", NaverConfig.NaverClientId);
			httpConn.setRequestProperty("X-Naver-Client-Secret", NaverConfig.NaverClientSecret);
			
			// 네이버야 내가 지금 query를 보냈는데 어때??
			int resCode = httpConn.getResponseCode();
			
			log.debug("상태코드 : " + resCode);
			
			if(resCode == 200) {
				InputStreamReader is = new InputStreamReader(httpConn.getInputStream());
				
				BufferedReader buffer = new BufferedReader(is);
				
				String retString = "";
				String reader = new String();
				while(true) {
					reader = buffer.readLine();
					if(reader == null)break;
					retString += reader;
				}
				buffer.close();
				
				return this.strToJson(retString);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
	}
}
