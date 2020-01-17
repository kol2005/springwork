package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.repository.BookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	private final BookDao bDao;
	
	public List<BookVO> selectAll() {
		return bDao.selectAll();
	}

}
