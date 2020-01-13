package com.biz.gallery.domain;

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
public class MemberVO {

	private String u_id;//	varchar2(125 byte)
	private String u_nick;//	nvarchar2(125 char)
	private String u_name;//	nvarchar2(125 char)
	private String u_password;//	varchar2(125 byte)
	private String u_tel;//	varchar2(20 byte)
	private String u_grade;//	varchar2(5 byte)
	
}
