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
public class HobbyDTO {
	
	private String h_code;//	NUMBER	NOT NULL	PRIMARY KEY,
	private String h_name;//	VARCHAR2(125)	NOT NULL,
	private String h_rem;//	VARCHAR2(5)	NOT NULL
	
}
