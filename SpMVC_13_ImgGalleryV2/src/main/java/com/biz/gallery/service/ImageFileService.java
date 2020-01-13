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
		for (ImageFilesVO file : img_files) {
			ret += ifDao.insert(file);
		}
		return ret;
	}

	public int imageFileInsert(List<ImageFilesVO> img_files,long img_p_code) {

		int ret = ifDao.bulk_insert(img_files, img_p_code);
		return ret;
	}

	public ImageFilesVO findBySeq(String img_id) {
		return ifDao.findBySeq(Long.valueOf(img_id));
	}

	public int img_file_delete(String img_id) {
		// TODO Auto-generated method stub
		return ifDao.delete(Long.valueOf(img_id));
	}

}
