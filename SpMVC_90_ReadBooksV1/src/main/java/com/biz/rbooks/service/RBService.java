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

	public List<RBookVO> findByBCode(String b_code) {
		return rbDao.findByBCode(b_code);
	}

	public int insert(RBookVO rBookVO) {
		int ret = rbDao.insert(rBookVO);
		return ret;
	}

	public RBookVO findBySeq(long rb_seq) {
		return rbDao.findBySeq(rb_seq);
	}

	public int update(RBookVO rBookVO) {
		return rbDao.update(rBookVO);
	}

	public int delete(long rb_seq) {
		return rbDao.delete(rb_seq);
	}
	
	
	
}
