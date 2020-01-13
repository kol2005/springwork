package com.biz.gallery.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.biz.gallery.domain.MemberVO;

public interface MemberDao {

	@Select("SELECT COUNT(*) FROM tbl_user")
	public int memberCount();
	
	@Select("SELECT * FROM tbl_user WHERE u_id = #{u_id}")
	public MemberVO findById(String u_id);
	
	@Insert("INSERT INTO tbl_user (u_id,u_password,u_name,u_grade)"
			+ " VALUES(#{u_id},#{u_password},#{u_name,jdbcType=VARCHAR},#{u_grade} )")
	public int insert(MemberVO memberVO);
	
}
