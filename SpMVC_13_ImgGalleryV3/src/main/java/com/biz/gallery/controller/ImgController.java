package com.biz.gallery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.domain.MemberVO;
import com.biz.gallery.service.ImageServiceV3;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("imageVO")
@Slf4j
@RequestMapping(value="/image")
@Controller
public class ImgController {
	
	ImageServiceV3 imService;
	
	@Autowired
	public ImgController(ImageServiceV3 imService) {
		this.imService = imService;
	}

	@ModelAttribute("imageVO")
	public ImageVO newImageVO() {
		return new ImageVO();
	}
	
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String upload(@ModelAttribute("imageVO") ImageVO imageVO,Model model,HttpSession httpSession) {
		/*
		MemberVO member = (MemberVO) httpSession.getAttribute("MEMBER");
		if(member == null) {
			model.addAttribute("MODAL","LOGIN");
			return "home";
		}
		*/
		
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
		
		log.debug("업로드 : " + imageVO.toString());
		imService.insert(imageVO);
		status.setComplete();
		return "redirect:/image/list";
	}
	
	/*
	 * @RequestParam : ?변수=값 형식으로 전송하고 변수에서 수신
	 * @PathVariable : path/값 형식으로 전송하고 변수에서 받기
	 */
	@RequestMapping(value="/update/{img_seq}",method=RequestMethod.GET)
	public String update(@PathVariable("img_seq") String img_seq,Model model,HttpSession httpSession) {
		/*
		// login이 되었는지 아닌지만 검사하기 위해
		// Object형으로 session객체를 추출
		Object memberVO = httpSession.getAttribute("MEMBER");
		if(memberVO == null) {
			model.addAttribute("MODAL","LOGIN");
			return "home";
		}
		*/
		ImageVO imgVO = imService.findBySeq(img_seq);
		model.addAttribute("BODY","UPLOAD");
		model.addAttribute("imageVO",imgVO);
		return "home";
	}
	
	@RequestMapping(value="/update/{img_seq}",method=RequestMethod.POST)
	public String update(@ModelAttribute("imageVO") ImageVO imageVO,SessionStatus status) {
		
		log.debug("IMAGEVO : " + imageVO.getImg_files());
		
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
	public  String delete(@PathVariable String img_seq,SessionStatus status,HttpSession httpSession,Model model) {
		
		// login이 되었는지 아닌지만 검사하기 위해
		// Object형으로 session객체를 추출
		Object memberVO = httpSession.getAttribute("MEMBER");
		if(memberVO == null) {
			model.addAttribute("MODAL","LOGIN");
			return "home";
		}
		
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
	 * 다중파일 수신하여 업로드를 수행한후
	 * 파일리스트를 view와 결합하여 DB에 저장전 보여주기
	 */
	@RequestMapping(value="/files_up",method=RequestMethod.POST)
	public String files_up(MultipartHttpServletRequest mFiles,Model model) {
		List<ImageFilesVO> fileNames = imService.files_up(mFiles);
		model.addAttribute("imgList",fileNames);
		return "include/img_upload_list";
	}
	
}
