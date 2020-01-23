package com.biz.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ems.domain.NaverLoginOK;
import com.biz.ems.service.NaverLoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/member")
public class MemberController {

	private final NaverLoginService nLoginService;
	
	@RequestMapping(value="/naver",method=RequestMethod.GET)
	public String naver_login() {
		String apiURL = nLoginService.oAuthLoginGet();
		return "redirect:" + apiURL;
	}
	
	@ResponseBody
	@RequestMapping(value="/naver/ok",method=RequestMethod.GET)
	public NaverLoginOK naver_ok(@ModelAttribute NaverLoginOK naverOk) {
		return naverOk;
	}
	
}
