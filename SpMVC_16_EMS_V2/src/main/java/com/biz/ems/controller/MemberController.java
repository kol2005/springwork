package com.biz.ems.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ems.domain.NaverMember;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;
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
	
	/*
	 * 네이버에 로그인 요청을 보낼때
	 * 네이버가 return 할 url 부분
	 * 외부에서 접속할수 있는 URL 이어야 한다
	 * 
	 * 네이버에 로그인이 성공하면
	 * 실제로 네이버에서 로그인 인증정보를 보내준다
	 */
	//@ResponseBody
	@RequestMapping(value="/naver/ok",method=RequestMethod.GET)
	public String naver_ok(@ModelAttribute NaverReturnAuth naverOk,HttpSession httpSession) {
		NaverTokenVO nToken = nLoginService.oAuthAccessGetToken(naverOk);
		
		NaverMember memberVO = nLoginService.getNaverMemberInfo(nToken);
		
		httpSession.setAttribute("MEMBER", memberVO);
		return "redirect:/ems/list";
	}
	
}
