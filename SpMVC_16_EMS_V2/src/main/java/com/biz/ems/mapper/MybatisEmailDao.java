package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.ems.domain.EmailVO;

public interface MybatisEmailDao {

	@Select("SELECT * FROM tbl_ems")
	public List<EmailVO> selectAll();
	
}
