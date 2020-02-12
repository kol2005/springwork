package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.BBsVO;

@Service
public interface BBsService {

	public List<BBsVO> selectAll();
	public BBsVO findById(long bbs_id);
	
	// 제목으로 검색하기
	public List<BBsVO> findBySubjects(String subject);
	
	// 작성자로 검색하기
	public List<BBsVO> findByWriters(String writer);
	
	// 제목과 작성자로 검색하기
	public List<BBsVO> findBySubAndWriter(String subject, String writer);
	
	// insert와 update를 처리할 service
	public int save(BBsVO bbsVO);
	
	public int delete(long bbs_id);
	public BBsVO replay(BBsVO bbsVO);
	
}
