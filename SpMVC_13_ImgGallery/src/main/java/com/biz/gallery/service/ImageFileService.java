package com.biz.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.repository.ImageFileDao;

@Service
public class ImageFileService {

	ImageFileDao ifDao;
	
	@Autowired
	public ImageFileService(ImageFileDao ifDao) {
		this.ifDao = ifDao;
	}
	
	public int imageFileInsert(List<ImageFilesVO> img_files) {
		
		int ret = 0;
		for(ImageFilesVO file : img_files) {
			ret += ifDao.insert(file);
		}
		return ret;
	}
	
}
