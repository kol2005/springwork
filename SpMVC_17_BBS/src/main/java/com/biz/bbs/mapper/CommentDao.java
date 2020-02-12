package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.CommentVO;

public interface CommentDao {

	@Select("SELECT * FROM tbl_comment WHERE cmt_p_id = #{cmt_p_id}")
	public List<CommentVO> selectAll(long cmt_p_id);
	
	public int insert(CommentVO cmmVO);
	public int update(CommentVO cmmVO);
	public int delete(long cmt_id);
	
}
