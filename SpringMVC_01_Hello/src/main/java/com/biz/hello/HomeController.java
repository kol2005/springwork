package com.biz.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping(value = "my",method=RequestMethod.POST)
	public String my(Model model,String strName,String strDept) {
		System.out.println(strName);
		System.out.println(strDept);
		return "mypage";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("st_name", "이몽룡이");
		model.addAttribute("st_dept", "컴퓨터공학과");
		model.addAttribute("st_grade", 3);
		
		return "home";
	}
	
}
