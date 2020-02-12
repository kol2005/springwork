package com.biz.friend.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.friend.domain.FriendVO;

public interface FriendDao {

	@Select("SELECT * FROM tbl_friend")
	public List<FriendVO> selectAll();

	public int insert(FriendVO fVO);

	@Select("SELECT * FROM tbl_friend WHERE f_id = #{f_id}")
	public FriendVO findById(long f_id);

	@Delete("DELETE FROM tbl_friend WHERE f_id = #{f_id}")
	public int delete(long f_id);

	public int update(FriendVO fVO);

	public List<FriendVO> findBySearch(String f_name);

}
