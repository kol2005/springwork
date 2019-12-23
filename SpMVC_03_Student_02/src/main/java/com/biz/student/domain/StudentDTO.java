package com.biz.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * DB 설계를 수행한 후
 * 설계된 TABLE과 연계되는 DTO(VO)클래스를 선언
 * 
 * 추상화단계
 * 객체지향에서 DTO, VO를 설계하는 단계
 * 실제 상황에서 사용되는 데이터를 특징적인 부분들만 추출하여
 * 특정한 클래스로 설계하는 단계
 * 
 * 학번, 학생이름, 학과, 학년, 전화번호, 주소, 담임교수
 * st_num, st_name, st_dept, st_grade, st_tel, st_addr, st_pro
 */
@Getter
@Setter
@AllArgsConstructor//모든 필드생성자
@NoArgsConstructor//super (기본)생성자
@ToString
@Builder
public class StudentDTO {

	private String st_num; // 201901001
	private String st_name;
	private String st_dept;
	private int st_grade;
	private String st_tel;
	private String st_addr;
	private String st_pro;
	
}
