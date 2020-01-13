package com.biz.rbooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rbooks.domain.RBookVO;
import com.biz.rbooks.service.RBService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("rbookVO")
@Slf4j
@RequestMapping(value="/rbook")
@Controller
public class RBookController {

	@Autowired
	RBService rbService;
	
	public RBookVO newRBookVO() {
		return new RBookVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<RBookVO> rbList = rbService.selectAll();
		model.addAttribute("rbList",rbList);
		return "home";
	}
	
	@RequestMapping(value="/bookinfo",method=RequestMethod.GET)
	public String bookinfo(@RequestParam("b_code") String rb_bcode,@ModelAttribute RBookVO rbookVO, Model model,HttpSession hSession) {
		rbookVO = rbService.getBCode(rb_bcode);
		model.addAttribute("rbList",rbookVO);
		return "rbook";
	}
	
	
}
