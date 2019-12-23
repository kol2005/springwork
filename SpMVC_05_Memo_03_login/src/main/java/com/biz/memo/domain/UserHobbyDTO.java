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
public class UserHobbyDTO {
	
	private long uh_seq;//	NUMBER	NOT NULL	PRIMARY KEY,
	private String uh_id;//	VARCHAR2(125)	NOT NULL,
	private String uh_code;//	VARCHAR2(5)	NOT NULL
	
}
