package com.biz.rbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.repository.MemberDao;

@Service
public class MemberService {

	@Autowired
	SqlSession sqlSession;
	
	MemberDao mDao;

	@Autowired
	public void getMapper() {
		mDao = sqlSession.getMapper(MemberDao.class);
	}
	
	public List<MemberVO> selectAll() {
		return mDao.selectAll();
	}
	
	
	
}
