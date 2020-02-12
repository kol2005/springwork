package com.biz.ems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeNaverSec {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		// 환경변수 가져오기
		Map<String,String> envList = System.getenv();
		
		String saltPass = envList.get("NAVER");
		System.out.println("SaltPass : " + saltPass);
		
		if(saltPass == null || saltPass.isEmpty()) {
			System.out.println("salt Password Not Found");
			return;
		}
		
		// 암호화 설정
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		Map<String,String[]> secFileList = new TreeMap<String,String[]>();
		
		secFileList.put("hiber.user.properties",
				new String[] {"mysql.user","mysql.password"});
		secFileList.put("naver.email.properties",
				new String[] {"naver.username","naver.password","naver.client.id","naver.client.secret"});
		
		String proFileDir = "./src/main/webapp/WEB-INF/spring/appServlet/props";
		
		Set<String> files = secFileList.keySet();
		
		try {
			for(String file : files) {
				File proFile = new File(proFileDir,file);
				System.out.println("=======================================");
				System.out.println(proFile.getAbsolutePath() + "파일 생성");
				System.out.println("---------------------------------------");
				
				PrintWriter out = new PrintWriter(proFile);
				
				for(String key : secFileList.get(file)) {
					System.out.print(key + " : ");
					String plainString = scanner.nextLine();
					if(plainString.isEmpty()) {
						System.out.println("Exit");
						out.close();
						return;
					}
					String encString = pbEnc.encrypt(plainString);
					
					// 변수=ENC(값)
					encString = String.format("%s=ENC(%s)", key,encString);
					System.out.println(encString);
					out.println(encString);
					out.flush();
				}
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		scanner.close();
	}
}
