package com.biz.rbooks.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.RBookVO;
import com.biz.rbooks.repository.RBDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RBService {

	@Autowired
	SqlSession sqlSession;
	
	RBDao rbDao;
	
	@Autowired
	public void getMapper() {
		rbDao = sqlSession.getMapper(RBDao.class);
	}
	
	public List<RBookVO> selectAll(){
		return rbDao.selectAll();
	}

	public RBookVO getBCode(String rb_bcode) {
		//RBookVO rbookVO = rbDao.findByBCode(b_code);
		return rbDao.getBCode(rb_bcode);
	}

	public RBookVO findByBCode(String b_code) {
		return null;
	}
	
	
	
}
