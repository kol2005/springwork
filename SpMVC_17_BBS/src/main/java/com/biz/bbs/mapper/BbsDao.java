package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.BBsVO;

@Mapper
public interface BbsDao {

	@Select("SELECT * FROM tbl_bbs ORDER BY bbs_date DESC, bbs_time DESC")
	public List<BBsVO> selectAll();
	
	public List<BBsVO> selectMain();

	public void update(BBsVO bbsVO);

	public void insert(BBsVO bbsVO);

	@Select("SELECT * FROM tbl_bbs WHERE bbs_id = #{bbs_id}")
	public BBsVO findById(long bbs_id);
}
