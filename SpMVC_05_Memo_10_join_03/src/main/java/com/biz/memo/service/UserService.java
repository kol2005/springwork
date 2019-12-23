package com.biz.memo.service;

import com.biz.memo.domain.UserDTO;

public interface UserService {

	/*
	 * 회원가입처리 : insert
	 * 회원가입처리를 할때
	 * 최초의 가입을 할떄는 그 사용자는 관리자이다
	 * 아직 테이블에 회원정보가 아무것도 없는 상태에서
	 *  회원가입을 하면 해당 사용자의 u_grade 칼럼을 "A"로 설정
	 *  그리고 아후 가입자는 일반사용자에 설정
	 */
	public int userJoin(UserDTO userDTO);
	
	/*
	 * id중복검사
	 * 새로 회원가입을 실시할떄
	 * 입력한 id가 기존 table에 저장되어 있는지 검사
	 * 
	 * u_id를 매개변수로 받아서
	 * table에서 회원 id를 검사한 후
	 * 이미 해당 id가 테이블에 있으면 true return
	 * 없으면 false return
	 */
	public boolean userIdCheck(String u_id);
	
	/*
	 *  로그인처리
	 *  회원id와 password를 전달받아서 정상적인 정보인지 검사
	 *  회원id와 비밀번호를 매개변수로 받아서
	 *  해당 정보와 일치하는(id and 비밀번호) 값이 있으면
	 *  true return 
	 *  그렇지 않으면 (회원정보가 없거나, 비번이 틀리면)
	 *  false return
	 */
	public boolean userLoginCheck(UserDTO userDTO);

	public UserDTO getUser(String u_id);
	
}
