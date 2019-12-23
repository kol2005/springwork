package com.biz.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(value="/student/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("BODY","STUDENT-LIST");
		
		//return null;// "/student/list.jsp"
		return "home";
	}
}
