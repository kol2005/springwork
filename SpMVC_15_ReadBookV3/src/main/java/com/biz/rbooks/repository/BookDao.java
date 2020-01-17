package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.BookVO;

public interface BookDao {

	@Select("SELECT * FROM tbl_books")
	public List<BookVO> selectAll();

}
