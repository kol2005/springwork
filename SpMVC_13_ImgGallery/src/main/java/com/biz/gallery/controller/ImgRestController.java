package com.biz.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biz.gallery.service.FileService;

@RequestMapping(value="/rest")
@RestController
public class ImgRestController {

	@Autowired
	FileService fService;
	
	@RequestMapping(value="/file_up",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String file_up(@RequestParam("file") MultipartFile upfile) {
		String upLoadFileName = fService.file_up(upfile);
		if(upLoadFileName == null)return "FAIL";
		else return upLoadFileName;
	}
	
}
