package com.biz.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.product.domain.ProFileDTO;
import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.FileDao;
import com.biz.product.persistence.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	FileService fService;
	
	ProductDao proDao;
	
	FileDao fileDao;
	
	@Autowired
	public void newDao() {
		this.proDao = sqlSession.getMapper(ProductDao.class);
		this.fileDao = sqlSession.getMapper(FileDao.class);
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

	
	public int insert(ProductDTO proDTO, List<ProFileDTO> upFileList) {
		/*
		 * 코드생성
		 */
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
		//----------------------------------------------------------
		
		proDTO.setP_code(p_code);
		
		/*
		 * 파일 리스트에 상품코드를 등록하여
		 * 상품과 파일리스트간의 연관을 설정하기
		 */
		log.debug("업로드 파일 정보" + upFileList);
		if(upFileList != null) {
			
			// 상품정보에 등록할 상품코드를 파일정보에 업데이트
			int nSize = upFileList.size();
			fileDao.filesInsert(upFileList,p_code);
			/*
			 * 파일의 개수만큼 tbl_files에 insert를 수행해야 하는데
			 * mybatis foreach를 활용한 동적쿼리를 작성하여
			 * 한번의 connextion으로 다수의 레코드에 insert를 수행한다
			 */
			
			/*
			for(int i = 0 ; i < nSize ; i++) {
				upFileList.get(i).setFile_p_code(p_code);
				log.debug("파일정보 : " + upFileList.get(i).toString());
				
				// 파일정보를 1씩 DBMS에 insert 수행하기
				// fileDao.fileInsert(upFileList.get(i));
			}*/
			//fileDao.fileList(upFileList);
			
		}
		// 상품테이블에 상품정보 추가
		int ret = proDao.insert(proDTO);
		return ret;
	}
	
	public int update(ProductDTO proDTO) {
		return proDao.update(proDTO);
	}

	public int update(ProductDTO proDTO, List<ProFileDTO> upFileList) {
		if(upFileList != null) {
			String p_code = proDTO.getP_code();
			fileDao.filesInsert(upFileList,p_code);	
		}
		return proDao.update(proDTO);
	}

	// sub file 삭제
	// 1. tbl_files 에서 file_seq에 해당하는 이미지 파일 정보를 가져오기
	// 2. 이미지 파일을 삭제하고
	// 3. 이미지 파일이 삭제가 완료되면 table에서 파일 정보를 제거
	public String subImgDelete(String file_seq) {
		
		// 1
		ProFileDTO proFileDTO = fileDao.findByFileSeq(file_seq);
		String file_name = proFileDTO.getFile_upload_name();// 파일이름
		String p_code = proFileDTO.getFile_p_code(); //상품코드
		
		// 2
		fService.fileDelete(file_name);
		
		// 3 table 정보 제거
		fileDao.fileDelete(file_seq);
		
		return p_code;
	}
	
}
