package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.ReadBookVO;


@Mapper
public interface ReadBookDao {

	@Select("SELECT * FROM tbl_read_book")
	public List<ReadBookVO> selectAll();

	
}
