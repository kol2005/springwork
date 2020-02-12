package com.biz.crawl.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.service.MovieCrawlService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final MovieCrawlService mcService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<NaverMovieVO> naverList = mcService.selectAll();
		model.addAttribute("NAVER_LIST",naverList);
		return "home";
	}
	
}
