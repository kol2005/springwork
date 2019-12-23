package com.biz.gdata.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.biz.gdata.config.DataGoConfig;

@Service
public class TourService {

	private String tour_url;

	public String getQueryString() throws UnsupportedEncodingException {

		String queryString = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";

		queryString += "?ServiceKey=" + DataGoConfig.goDataAuith;
		queryString += "&MobileApp=" + URLEncoder.encode(DataGoConfig.MY_APP_NAME, "UTF-8");
		queryString += "&_type=json";
		queryString += "&MobileOS=ETC";

		queryString += String.format("&numOfRows=%d", 10);
		queryString += String.format("&pageNo=%d", 1);

		return queryString;

	}

	public JSONArray getData() throws ParseException, IOException {
		JSONParser jParser = new JSONParser();
		JSONObject jObject = (JSONObject) jParser.parse(this.getDataString());
		
		JSONArray jArray = null;
		JSONObject oBody = (JSONObject)jObject.get("body");
		JSONObject oitems = (JSONObject)oBody.get("items");
		JSONArray oitem = (JSONArray)jObject.get("item");
				
		
		return null;
	}
	
	public String getDataString() throws IOException {

		URL url = new URL(this.getQueryString());
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		int resCode = httpConn.getResponseCode();

		BufferedReader buffer = null;
		if (resCode == 200) {
			InputStreamReader is = new InputStreamReader(httpConn.getInputStream());
			buffer = new BufferedReader(is);
		} else {
			InputStreamReader is = new InputStreamReader(httpConn.getErrorStream());
			buffer = new BufferedReader(is);
		}
		String retString = "";
		String reader = "";
		while (true) {
			reader = buffer.readLine();
			if (reader == null)
				break;

			retString += reader;
		}
		buffer.close();
		return retString;
	}

}
