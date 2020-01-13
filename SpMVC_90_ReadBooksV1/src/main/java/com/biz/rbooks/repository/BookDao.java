package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.rbooks.domain.BooksVO;

public interface BookDao {

	public List<BooksVO> selectAll();

	public int delete(String b_code);

	public int insert(BooksVO bookVO);

	public int update(BooksVO booksVO);

	public BooksVO findByBCode(@Param("b_code") String b_code);

}
