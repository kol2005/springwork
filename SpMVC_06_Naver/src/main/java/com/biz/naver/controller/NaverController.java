package com.biz.naver.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.naver.service.NaverService;

@RequestMapping(value="/naver")
@Controller
public class NaverController {
	
	@Autowired
	NaverService nService;

	
	@RequestMapping(value="/news",method=RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String news(String cat, String search, Model model) {
		
		JSONArray resArray = nService.getNews(cat,search);
		model.addAttribute("NAVER_ITEMS",resArray);
		
		return "home";
	}
}
