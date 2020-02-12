package com.biz.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.mapper.MybatisEmailDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MybatisService {

	private final MybatisEmailDao meDao;
	
	public List<EmailVO> selectAll() {
		return meDao.selectAll();
	}
}
