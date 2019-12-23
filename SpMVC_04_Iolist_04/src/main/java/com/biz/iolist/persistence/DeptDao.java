package com.biz.iolist.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.domain.DeptDTO;

public interface DeptDao {

	public List<DeptDTO> selectAll();
	public List<DeptDTO> findAll();
	
	public String getDCode();
	public int insert(DeptDTO deptDTO);
	public DeptDTO findByDCode(String d_code);
	public int delete(String d_code);
	public int update(DeptDTO deptDTO);
	/*
	 * @Param
	 * mapper에서 사용하는 변수와
	 * method의 매개변수가 다를 경우 사용하는 설정이며
	 * 
	 * 만약 매개변수가 2개 이상이면 반드시 각각의 변수를 모두
	 * @Param으로 설정해 주어야 한다
	 */
	public List<DeptDTO> findByDName(@Param("d_name") String strText);
}
