package com.biz.pet.controller;

import java.net.URISyntaxException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.pet.service.PetService;

@Controller
public class HomeController {

	@Autowired
	PetService pService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String home(Locale locale, Model model) throws URISyntaxException {
		
		return "redirect:/pet";
	}
	
}
