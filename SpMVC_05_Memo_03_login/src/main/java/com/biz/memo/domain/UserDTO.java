package com.biz.memo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

	private String u_id;
	private String u_password;
	private String u_name;
	private String u_nick;
	private String u_grade;
	private String u_tel;
	
	// 사용자의 취미를 여러가지 중복 선택할수 있도록 하는
	// 기능을 구현하기 위해 배열로 선언
	// checkbox와 연결되는 변수, 대응하는 변수
	private String[] u_hobby;
	
//	u_id	VARCHAR2(125)	NOT NULL	PRIMARY KEY,
//	u_nick	nVARCHAR2(125),
//	u_name	nVARCHAR2(125)	NOT NULL,
//	u_password	VARCHAR2(125)	NOT NULL,
//	u_tel	VARCHAR2(20),
//	u_grade	VARCHAR2(5)
	
	
}
