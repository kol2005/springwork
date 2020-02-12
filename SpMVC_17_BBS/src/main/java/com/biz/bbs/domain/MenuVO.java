package com.biz.bbs.domain;

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
public class MenuVO {
	private String menu_id;
	private String menu_p_id;
	private String menu_title;
	private String menu_href;
	
	/*
	 * drop down을 구현하기 위해서 자기 자신을 List로 설정
	 */
	List<MenuVO> drop_menus;
}
