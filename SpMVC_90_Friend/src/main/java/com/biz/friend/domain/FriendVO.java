package com.biz.friend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Alias("frVO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FriendVO {

	private long f_id;//	bigint	not null	primary key,
	private String f_name;//	varchar(20)	not null,
	private String f_tel;//	varchar(20)	not null,
	private String f_addr;//	varchar(125),
	private String f_hobby;//	varchar(10),
	private String f_relation;//	varchar(10)
	
}
