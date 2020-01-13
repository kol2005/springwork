package com.biz.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceV3 extends ImageServiceV2{

	@Autowired
	public ImageServiceV3(ImageDao imDao, FileService fService, ImageFileService ifService) {
		super(imDao, fService, ifService);
	}

	@Override
	public int insert(ImageVO imageVO) {
		imageVO = this.updateImageFiles(imageVO);
		int ret = imDao.insert(imageVO);
		long img_pcode = imageVO.getImg_seq();
		ifService.imageFileInsert(imageVO.getImg_up_files(),img_pcode);
		
		return ret;
	}

	@Override
	public int update(ImageVO imageVO) {
		imageVO = this.updateImageFiles(imageVO);		
		int ret = imDao.update(imageVO);
		long img_pcode = imageVO.getImg_seq();

		//log.debug("update : " + imageVO.getImg_files().toString());
		ifService.imageFileInsert(imageVO.getImg_up_files(),img_pcode);	
		
		return ret;
	}
	
	/*
	 * class Class{
	 * 	public void methodp() {}
	 * 	public int valuep = 0;
	 * 
	 * 	private void methodr() {}
	 * 	private int valuer = 0
	 * }
	 * 
	 * 접근 제한자, scope
	 * public 누구나 접근할수 있다
	 * 	Class c = new Class();
	 * 	c.methodp()
	 * 	c.valuep;
	 * 
	 * private 현재 클래스에서만 접근 가능
	 * 	Class c = new Class();
	 * 	c.method(); // 오류
	 * 	c.value; // 오류
	 * 
	 * protected는 현재 클래스와 상속받은 클래스에서만 접근가능 
	 */
	
	/*
	 * service, serviceV1, serviceV2에는 없응
	 * V3에만 있는 새로운 method이고 현재는 V3에서만 사용되는 method
	 * 만약 V3를 상속받아서 새로운 클래스를 만들경우에
	 * 사용할수 있도록 protected로 선언을 하였다
	 */
	protected ImageVO updateImageFiles(ImageVO imageVO) {
		List<ImageFilesVO> imgFiles = imageVO.getImg_up_files();
		if(imgFiles != null && imgFiles.size() > 0) {
			imageVO.setImg_file(imgFiles.get(0).getImg_file_upload_name());
			for(ImageFilesVO ifVO : imgFiles) {
				ifVO.setImg_file_origin_name(ifVO.getImg_file_upload_name().substring(36));
			}
		}
		return imageVO;
	}
	
}
