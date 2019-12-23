package com.biz.memo.persistence;

import java.util.List;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.domain.UserHobbyDTO;

public interface UserDao {
	
	public List<HobbyDTO> selectAllHobby();
	
	public int userCount();

	public int insert(UserDTO userDTO);

	public void uHInsert(UserHobbyDTO uh);
	
}
