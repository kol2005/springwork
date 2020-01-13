package com.biz.rbooks.repository;

import java.util.List;

import com.biz.rbooks.domain.RBookVO;

public interface RBDao {

	public List<RBookVO> selectAll();

	public RBookVO getBCode(String rb_bcode);

}
