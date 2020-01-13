package com.biz.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.service.FileService;
import com.biz.gallery.service.ImageFileService;

@RequestMapping(value="/rest")
@RestController
public class ImgRestController {

	
	private final FileService fService;
	private final ImageFileService ifService;
	
	@Autowired
	public ImgRestController(FileService fService, ImageFileService ifService) {
		super();
		this.fService = fService;
		this.ifService = ifService;
	}

	@RequestMapping(value="/file_up",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String file_up(@RequestParam("file") MultipartFile upfile) {
		String upLoadFileName = fService.file_up(upfile);
		if(upLoadFileName == null)return "FAIL";
		else return upLoadFileName;
	}
	
	@RequestMapping(value="/image_delete",method=RequestMethod.POST)
	public String img_delete(@RequestParam("img_id")String img_id) {
		try {
		ImageFilesVO imgVO = ifService.findBySeq(img_id); 
		fService.file_delete(imgVO.getImg_file_upload_name());
		ifService.img_file_delete(img_id);
		} catch (Exception e) {
			// TODO: handle exception
			return "FAIL";
		}
		return "OK";
	}
	
}
