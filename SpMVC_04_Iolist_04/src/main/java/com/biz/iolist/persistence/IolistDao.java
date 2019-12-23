package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;

public interface IolistDao {

	public List<IolistVO> viewSelectAll();

	public int insert(IolistDTO ioDTO);

	public IolistVO findBySeq(long io_seq);

}
