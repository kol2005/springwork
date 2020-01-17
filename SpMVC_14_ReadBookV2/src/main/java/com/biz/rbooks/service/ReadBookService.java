package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.RequiredArgsConstructor;

/*
 * private final 변수에 대한 생성자를 자동으로 만들고
 * Autowired를 붙여서 주입할수 있도록 설정
 */
@RequiredArgsConstructor
@Service
public class ReadBookService {

	private final ReadBookDao rBookDao;

	public int insert(ReadBookVO rBookVO) {
		int ret = rBookDao.insert(rBookVO);
		return ret;
	}

	public List<ReadBookVO> selectAll() {
		return rBookDao.selectAll();
	}

	public ReadBookVO findBySeq(long rb_seq) {
		return rBookDao.findBySeq(rb_seq);
	}

	public int update(ReadBookVO rBookVO) {
		int ret = rBookDao.update(rBookVO);
		return ret;
	}

	public int delete(Long rb_seq) {
		return rBookDao.delete(rb_seq);
	}

	public List<ReadBookVO> findByBCode(String b_code) {
		return rBookDao.findByBCode(b_code);
	}
	
}
