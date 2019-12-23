package com.biz.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeptController {

	@RequestMapping(value="dept/list",method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("BODY","DEPT-LIST");
		return "home";
	}
}
