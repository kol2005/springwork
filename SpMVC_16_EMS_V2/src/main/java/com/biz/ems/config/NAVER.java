package com.biz.ems.config;

public class NAVER {

	public static class TOKEN {
	
	public final static String grant_type = "grant_type";
	public final static String client_id = "client_id";
	public final static String client_secret = "client_secret";
	public final static String code = "code";
	public final static String state = "state";
	public final static String refresh_token = "refresh_token";
	public final static String access_token = "access_token";
	public final static String service_provider = "service_provider";
	
	}
	
	public static class GRANT_TYPE {
		
		public final static String authorization_code = "authorization_code"; // 발급
		public final static String refresh_token = "refresh_token";// 갱신
		public final static String delete = "delete";// 삭제
		
	}
}
