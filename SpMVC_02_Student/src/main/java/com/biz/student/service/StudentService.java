package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

// @Service : Spring framework container 에 등록될 bean 이다 라는 선언
@Slf4j
@Service
public class StudentService {

	public List<String> getList() {
		
		List<String> strList = new ArrayList<String>();
		
		strList.add("홍길동");
		strList.add("이몽룡");
		strList.add("성춘향");
		strList.add("임꺽정");
		strList.add("장보고");
		strList.add("장녹스");
		strList.add("김계동"); // 개똥
		
		return strList;
		
	}
}
