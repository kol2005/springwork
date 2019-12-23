package com.biz.bok.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.bok.domain.BokSearchDTO;
import com.biz.bok.service.CodeService;

@Controller
public class HomeController {

//	@Autowired
//	CodeService cService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
//		model.addAttribute("bokSearchDTO",new BokSearchDTO());
//		model.addAttribute("SeMap",cService.getSelectMaps());
		
		return "redirect:/search";
	}
	
}
