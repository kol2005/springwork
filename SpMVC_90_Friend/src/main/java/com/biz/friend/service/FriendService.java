package com.biz.friend.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.repository.FriendDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FriendService {

	private final FriendDao fDao;

	public List<FriendVO> selectAll() {
		return fDao.selectAll();
	}

	public int insert(FriendVO fVO) {
		return fDao.insert(fVO);
	}

	public FriendVO findById(long f_id) {
		return fDao.findById(f_id);
	}

	public int delete(long f_id) {
		return fDao.delete(f_id);
	}

	public int update(FriendVO fVO) {
		return fDao.update(fVO);
	}

	public List<FriendVO> findBySearch(String f_name) {
		return fDao.findBySearch(f_name);
	}

}
