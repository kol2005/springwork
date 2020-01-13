package com.biz.rbooks.domain;

import java.util.List;

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
public class BooksVO {

	private String b_code;//	varchar2(20 byte)
	private String b_name;//	nvarchar2(125 char)
	private String b_auther;//	nvarchar2(125 char)
	private String b_comp;//	nvarchar2(125 char)
	private String b_year;//	varchar2(10 byte)
	private int b_iprice;//	number
	
	private List<String> books_list;
	
}
