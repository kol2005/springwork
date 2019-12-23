package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.DeptDTO;

public interface DeptDao {

	public List<DeptDTO> selectAll();
	public List<DeptDTO> findAll();
}
