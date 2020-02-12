package com.biz.bbs.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.biz.bbs.domain.BBsVO.BBsVOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("cmmVO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CommentVO {

	private long cmt_id;//	bigint
	private long cmt_p_id;//	bigint
	private String cmt_writer;//	varchar(20)
	private String cmt_date;//	varchar(10)
	private String cmt_time;//	varchar(10)
	private String cmt_text;//	varchar(400)

}
