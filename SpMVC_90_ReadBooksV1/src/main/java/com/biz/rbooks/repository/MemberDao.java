package com.biz.rbooks.repository;

import java.util.List;

import com.biz.rbooks.domain.MemberVO;

public interface MemberDao {

	List<MemberVO> selectAll();
}
