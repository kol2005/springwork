package com.biz.iolist.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	public List<ProductDTO> findAll();
	
	public String getPCode();
	public int insert(ProductDTO proDTO);
	public ProductDTO findByPCode(String p_code);
	public int delete(String p_code);
	public int update(ProductDTO proDTO);
	public List<ProductDTO> findByName(@Param("p_name") String strText);

}
