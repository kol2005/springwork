package com.biz.iolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/param")
@Controller
public class ParamController {

	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view() {
		
		return "/param/view";
		//return null;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id) {
		
		return "/param/update";
		//return null;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(String code, Model model) {
		
		System.out.println(code);
		
		
		return "/param/update";
		//return null;
	}
}
