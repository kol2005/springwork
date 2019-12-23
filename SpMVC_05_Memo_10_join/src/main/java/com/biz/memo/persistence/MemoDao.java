package com.biz.memo.persistence;

import java.util.List;

import com.biz.memo.domain.MemoDTO;

public interface MemoDao {

	public List<MemoDTO> selectAll();
	public MemoDTO findById(long m_seq);
	public List<MemoDTO> findByCategory(String m_cat);
	public List<MemoDTO> findBySearch(MemoDTO memoDTO);
	
	public int insert(MemoDTO memoDTO);
	public int update(MemoDTO memoDTO);
	
	public int delete(long m_seq);
}
