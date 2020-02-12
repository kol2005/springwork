package com.biz.ems.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biz.ems.domain.EmailVO;

@Repository
public interface EmailDao extends CrudRepository<EmailVO, Long>{

	//EmailVO findByEmsSeq(long ems_seq);
	
	// select * from tbl_ems WHERE from_email = #{from_email}
//	List<EmailVO> findAllByFromEmail(String from_email);
//	List<EmailVO> findAllByFromEmailOrderByEmsSeqAsc(String from_email);
	
	// >
//	List<EmailVO> findAllBySendDateGreaterThan(String send_date);
	
	// <
//	List<EmailVO> findAllBySendDateLessThan(String send_date);
	
//	List<EmailVO> findByFromEmailAndFromName(
//			@Param("from_email")String from_email,
//			@Param("from_name")String from_name);

//	List<EmailVO> findByFromEmailOrFromName(
//			@Param("from_email")String from_email,
//			@Param("from_name")String from_name);
	
}
