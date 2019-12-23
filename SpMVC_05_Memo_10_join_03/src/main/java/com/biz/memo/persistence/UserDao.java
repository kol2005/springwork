package com.biz.memo.persistence;

import org.apache.ibatis.annotations.Param;

import com.biz.memo.domain.UserDTO;

public interface UserDao {

	public int userInsert(UserDTO userDTO);
	
	// 회원테이블의 전체 회원수를 조회하는 method
	public int userCount();

	public UserDTO findById(@Param("u_id") String u_id);

}
