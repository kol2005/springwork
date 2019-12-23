package com.biz.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.ProductDao;

@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;
	
	
	ProductDao proDao;
	
	@Autowired
	public void proDao() {
		this.proDao = sqlSession.getMapper(ProductDao.class);
	}
	
	public ProductDTO findByPCode(String p_code) {
		return proDao.findByPCode(p_code);
	}
	
	public List<ProductDTO> findByPNames(String p_name) {
		return proDao.findByPNames(p_name);
	}

	public List<ProductDTO> selectAll() {
		return proDao.selectAll();
	}

	public int insert(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		String p_code = proDao.getMaxPCount();
		String p_prefixCode = "P";
		// 만약 상품테이블에 데이터가 하나도 없을 경우
		// intPCode 를 1로 세팅한 상태로 다음으로 진행
		int intPCode = 1;
		try {
			p_prefixCode = p_code.substring(0,1);
			String p_surfixCode = p_code.substring(1);
			intPCode = Integer.valueOf(p_surfixCode)+1;	
		} catch (Exception e) {
		}
		// P0001 형식으로 코드 문자열 생성
		p_code = String.format("%s%04d",p_prefixCode, intPCode);
		proDTO.setP_code(p_code);
		 
		return proDao.insert(proDTO);
	}

	public int update(ProductDTO proDTO) {
		// TODO Auto-generated method stub
		return proDao.update(proDTO);
	}
	
}
