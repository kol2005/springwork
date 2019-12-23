package com.biz.memo.service;

import java.util.List;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;

public interface UserService {

	// 회원가입(insert)
	public int userJoin(UserDTO userDTO);
	/*
	 *  아이디 중복검사
	 *  만약 동일한 id가 테이블에 있으면 true return
	 *  없으면 false return
	 */
	public boolean userIdCheck(String u_id);
	/*
	 *  로그인 확인
	 *  1. userDTO를 매개변수로 받아서
	 *  	DB에서 id와 password를 검사한 다음
	 *  2. id와 password가 모두 일치하면 UserDTO 객체를 return하고
	 *  3. 그렇지 않으면 (로그인 실패) null 을 return
	 */
	public UserDTO userLoginCheck(UserDTO userDTO);
	//회원정보변경
	public int userUpdate(UserDTO userDTO);
	/*
	 *  회원탈퇴
	 *  회원정보를 삭제하는 것이 아니고
	 *  u_grade(등급) D로 설정하기(부분 Update)
	 */
	public void userOut(UserDTO userDTO);
	// 취미테이블 조회
	public List<HobbyDTO> getHobbyList();
	
	
}
