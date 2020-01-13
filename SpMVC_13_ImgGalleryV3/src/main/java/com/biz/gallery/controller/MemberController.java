package com.biz.gallery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.gallery.domain.MemberVO;
import com.biz.gallery.repository.MemberDao;
import com.biz.gallery.service.MemberService;

@RequestMapping(value="/member")
@Controller
public class MemberController {
	
	private final MemberService mService;
	
	@Autowired
	public MemberController(MemberService mService) {
		this.mService = mService;
	}

	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("MODAL","JOIN");
		return "home";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(MemberVO memberVO,Model model) {
		mService.insert(memberVO);
		return "redirect:/image/list";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "body/login";
	}
	
	//@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model , HttpSession httpSession) {
		
		//String u_id = memberVO.getU_id();
		//String u_password = memberVO.getU_password();
		
		memberVO = mService.loginCheck(memberVO);
		if(memberVO != null) {
			httpSession.setAttribute("MEMBER", memberVO);
			//return "LOGIN_OK";
		}else {
			httpSession.removeAttribute("MEMBER");
			//return "LOGIN_FAIL";
		}
		return "redirect:/image/list";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("MEMBER");
		return "redirect:/image/list";
	}
}
