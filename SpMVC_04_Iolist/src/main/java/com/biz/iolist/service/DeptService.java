package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.persistence.DeptDao;


@Service
public class DeptService {
	
	@Autowired
	SqlSession sqlSession;

	public List<DeptDTO> getAllList() {
		
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		List<DeptDTO> deptList = deptDao.selectAll();
		
		return deptList;
	}
}
