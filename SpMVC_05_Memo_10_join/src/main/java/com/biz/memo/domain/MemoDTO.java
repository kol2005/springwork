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
public class MemoDTO {

	private long m_seq;//		number
	private String m_date;//		varchar2(10 byte)
	private String m_time;//		varchar2(8 byte)
	private String m_auth;//		nvarchar2(20 char)
	private String m_subject;//	nvarchar2(125 char)
	private String m_text;//		nvarchar2(1000 char)
	private String m_flag;//		varchar2(1 byte)
	private String m_field;//		nvarchar2(20 char)
	private String m_ok;//			varchar2(1 byte)
	private String m_cat;//		nvarchar2(50 char)
	
}
