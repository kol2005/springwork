package com.biz.student.persistence;

import java.util.List;

import com.biz.student.domain.StudentVO;

public interface StudentDao {
	
	public List<StudentVO> selectAll();
	
}
