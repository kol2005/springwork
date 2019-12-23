package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.persistence.MemoDao;

// @Repository 를 사요할수도 있다
@Service
public class MemoService {

	/*
	 * Service를 사용하려고 시도하면
	 * sqlSession으로 부터 MemoDao mapper 를 추출하여
	 * mDao 객체를 사용할수 있도록 초기화 하라
	 */
	@Autowired
	SqlSession sqlSession;
	
	MemoDao mDao;
	
	@Autowired
	public void getMapper() {
		mDao = sqlSession.getMapper(MemoDao.class);
	}

	
	public List<MemoDTO> getAllList() {
		// TODO 전체 메모리스트를 DB로 부터 가져와서 Controller로 리턴
		return mDao.selectAll();
	}


	public List<MemoDTO> getSearchList(String m_subject) {
		// TODO 제목으로 검색하기
		MemoDTO memoDTO = MemoDTO.builder()
				.m_subject(m_subject)
				.build();
		
		return mDao.findBySearch(memoDTO);
	}
	
	public List<MemoDTO> insert() {
		
		
		return null;
	}


	public int insert(MemoDTO memoDTO) {
		 return mDao.insert(memoDTO);
	}
	
}
