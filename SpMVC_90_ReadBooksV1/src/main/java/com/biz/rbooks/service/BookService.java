package com.biz.rbooks.service;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.repository.BookDao;

@Service
public class BookService {

	@Autowired
	SqlSession sqlSession;
	
	BookDao bDao;
	
	@Autowired
	public void getMapper() {
		bDao = sqlSession.getMapper(BookDao.class);
	}
	
	public List<BooksVO> selectAll(){
		return bDao.selectAll();
	}
	
	public int insert(BooksVO bookVO) {
		return bDao.insert(bookVO);
	}

	public int delete(String b_code) {
		return bDao.delete(b_code);
	}

	public BooksVO findByBCode(String b_code) {
		return bDao.findByBCode(b_code);
	}

	public int update(BooksVO booksVO) {
		return bDao.update(booksVO);
	}

	public List<BooksVO> findByBNames(String strText) {
		List<String> names = Arrays.asList(strText.split(" "));
		List<BooksVO> bookList = bDao.findByBNames(names);
		return bookList;
	}
	
}
