package com.biz.rbooks.domain;

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
	
	private String m_id;//	varchar2(6 byte)
	private String m_password;//	nvarchar2(125 char)
	private String m_login_data;//	nvarchar2(125 char)
	private String m_rem;//	nvarchar2(125 char)
	
}
