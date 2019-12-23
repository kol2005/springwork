package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.domain.UserHobbyDTO;
import com.biz.memo.persistence.UserDao;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	SqlSession sqlSession;
	
	UserDao userDao;
	
	@Autowired
	public void newUserDao() {
		userDao = sqlSession.getMapper(UserDao.class);
	}

	@Override
	public int userJoin(UserDTO userDTO) {
		/*
		 * 최초로 등록되는 사용자는 관리자이다
		 * u_grade 값을 "A"로 셋팅한다.
		 * tbl_user 테이블에 데이터가 하나도 없으면
		 * 회원정보 DTO의 u_grade 필드 변수에 문자열 "A"를 저장하고
		 * 그렇지 않으면 "U"를 저장해서 insert를 수행하라
		 */
		if(userDao.userCount() > 0) {
			userDTO.setU_grade("U");
		}else {
			userDTO.setU_grade("A");
		}
		int ret = userDao.insert(userDTO);
		
		//
		String[] strHobby = userDTO.getU_hobby();
		for(String s: strHobby) {
			UserHobbyDTO uh = UserHobbyDTO.builder()
					.uh_id(userDTO.getU_id())
					.uh_code(s)
					.build();
			userDao.uHInsert(uh);
		}
		//
		
		return ret;
	}

	@Override
	public boolean userIdCheck(String u_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDTO userLoginCheck(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userUpdate(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void userOut(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HobbyDTO> getHobbyList() {
		return userDao.selectAllHobby();
	}



	
	
}
