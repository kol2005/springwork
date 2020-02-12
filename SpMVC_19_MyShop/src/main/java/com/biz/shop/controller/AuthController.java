package com.biz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/auth")
@Controller
public class AuthController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	//@ResponseBody
	@RequestMapping(value="/auth/test",method=RequestMethod.GET)
	public String test() {
		return "auth/test";
	}
}
