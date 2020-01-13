package com.biz.gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.service.ImageService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("imageVO")
@Slf4j
@RequestMapping(value="/image")
@Controller
public class ImgController {
	
	@Autowired
	ImageService imService;

	@ModelAttribute("imageVO")
	public ImageVO newImageVO() {
		return new ImageVO();
	}
	
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String upload(@ModelAttribute("imageVO") ImageVO imageVO,Model model) {
		
		log.debug("이미지 업로드 시작!!!");
		
		imageVO = new ImageVO();
		
		model.addAttribute("BODY","UPLOAD");
		model.addAttribute("imageVO",imageVO);
		
		return "home";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<ImageVO> imgList = imService.selectAll();
		model.addAttribute("imgList",imgList);
		return "home";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@ModelAttribute("imageVO") ImageVO imageVO,String[] mFiles,SessionStatus status) {
		
		imService.insert(imageVO);
		status.setComplete();
		return "redirect:/image/list";
	}
	
	/*
	 * @RequestParam : ?변수=값 형식으로 전송하고 변수에서 수신
	 * @PathVariable : path/값 형식으로 전송하고 변수에서 받기
	 */
	@RequestMapping(value="/update/{img_seq}",method=RequestMethod.GET)
	public String update(@PathVariable("img_seq") String img_seq,Model model) {
		//log.debug(img_seq);
		ImageVO imgVO = imService.findBySeq(img_seq);
		model.addAttribute("BODY","UPLOAD");
		model.addAttribute("imageVO",imgVO);
		return "home";
	}
	
	@RequestMapping(value="/update/{img_seq}",method=RequestMethod.POST)
	public String update(@ModelAttribute("imageVO") ImageVO imageVO,SessionStatus status) {
		
		// 이미지 이름이 기존의 이미지와 다르면 기존 이미지를 삭제
		// 서비스에 해당 기능 구현
		int ret = imService.update(imageVO);
		
		/*
		 * SessionAttribute를 사용할때
		 * 객체가 서버 메모리에 남아서 계속 유지되는 상태이
		 * insert, update 등을 수행할때
		 * 그 정보를 계속 사용해서 form에 값이 나타나게 된다
		 * 
		 * 그것을 방지하기 위해서
		 * insert, update가 완료된 후에는 반드시
		 * SessionStatus의 setComplete() method를 호출
		 * sessionAttribute를 해제 해주어야 한다
		 */
		status.setComplete();
		return "redirect:/image/list";
	}
	
	@RequestMapping(value="/delete/{img_seq}",method=RequestMethod.GET)
	public  String delete(@PathVariable String img_seq,SessionStatus status) {
		
		int ret = imService.delete(img_seq);
		
		status.setComplete();
		return "redirect:/image/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("img_seq") String img_seq,SessionStatus status,Model model) {
		
		int ret = imService.delete(img_seq);
		
		status.setComplete();
		return ret + "";
	}
	
	/*
	 * MultipartHttpServletRequest
	 * 다중파일 수신하기
	 */
	@RequestMapping(value="/files_up",method=RequestMethod.POST)
	public String files_up(MultipartHttpServletRequest mFiles,Model model) {
		List<String> fileNames = imService.files_up(mFiles);
		model.addAttribute("imgList",fileNames);
		return "include/img_card_box";
	}
	
}
