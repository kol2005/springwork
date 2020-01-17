package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.BookVO;

public interface BookDao {
	
	@Select("SELECT * FROM tbl_books")
	public List<BookVO> selectAll();
	
	
	public int insert(BookVO bookVO);
	/*
	 * Dao mathod에 Annotation을 붙이지 않으면 
	 * mapper.xml에서 id를 검색하여 해당 query로 사용한다
	 */
	public List<BookVO> findByBNames(@Param("names")List<String> names);

	@Select("SELECT * FROM tbl_books WHERE b_code = #{b_code}")
	public BookVO findByBCode(String b_code);

}
