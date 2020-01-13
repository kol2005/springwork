package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.service.BookService;
import com.biz.rbooks.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("memberVO")
@RequestMapping(value="/member")
@Slf4j
@Controller
public class MemberController {


	@Autowired
	BookService bService;
	
	@Autowired
	MemberService mService;
	
	@ModelAttribute("memberVO")
	public MemberVO newMemberVO() {
		return new MemberVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<MemberVO> mList = mService.selectAll();
		model.addAttribute("mList",mList);
		return "home";
	}
	
}
