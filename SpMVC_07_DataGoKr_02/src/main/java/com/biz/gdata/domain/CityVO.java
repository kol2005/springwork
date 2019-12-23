package com.biz.gdata.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * json 데이터를 변환하는 용도로 사용할 VO 클래스
 * 변수이름은 json 데이터의 칼럼과 같도록 해야 한다
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CityVO {
	
	private String code;
	private String name;

}
