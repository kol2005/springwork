package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.biz.rbooks.domain.RBookVO;

public interface RBDao {

	public List<RBookVO> selectAll();

	public RBookVO getBCode(String rb_bcode);

	public int insert(RBookVO rBookVO);

	public List<RBookVO> findByBCode(String b_code);

	public RBookVO findBySeq(long rb_seq);

	public int update(RBookVO rBookVO);

	//@Delete("DELETE FROM tbl_read_book WHERE rb_seq = #{rb_seq}")
	public int delete(long rb_seq);

}
