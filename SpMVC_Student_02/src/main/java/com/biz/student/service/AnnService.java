package com.biz.student.service;

import org.springframework.stereotype.Service;

 
// @Service // MVC 패턴에서 Service 클래스에 사용

// @Bean // 종류에 관계없이 사용, JDK에서 제공하는 클래스
// xml에 <bean>으로 설정할 클래스 선언과 생성을 대신하는 Annotation
//@Component // 종류에 관계없이 사용, 사용자가 작성한 클래스
@Service
public class AnnService {

	public void viewAnn() {
		System.out.println("대한민국만세");
		System.out.println("Republic Of Korea");
	}
}
