package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReadBookService {

	private final ReadBookDao rbDao;
	
	public List<ReadBookVO> selectAll() {
		List<ReadBookVO> rBookList = rbDao.selectAll();
		return rBookList;
	}

}
