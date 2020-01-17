package com.biz.rbooks.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.RBookVO;
import com.biz.rbooks.service.BookService;
import com.biz.rbooks.service.RBService;

import lombok.extern.slf4j.Slf4j;

//@SessionAttributes("rbookVO")
@Slf4j
@RequestMapping(value="/rbook")
@Controller
public class RBookController {

	@Autowired
	RBService rbService;
	
	@Autowired
	BookService bService;
	
	@ModelAttribute("rBookVO")
	public RBookVO newRBookVO() {
		return new RBookVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<RBookVO> rbList = rbService.selectAll();
		model.addAttribute("rbList",rbList);
		return "home";
	}
	
	@RequestMapping(value="/rbookinfo/{rb_seq}",method=RequestMethod.GET)
	public String rbookinfo(@PathVariable("rb_seq") long rb_seq, Model model) {
		RBookVO rBookVO = rbService.findBySeq(rb_seq);
		model.addAttribute("RBOOK",rBookVO);
		String b_code = rBookVO.getRb_bcode();
		BooksVO booksVO = bService.findByBCode(b_code);
		model .addAttribute("BOOK",booksVO);
		
		List<RBookVO> rbList = rbService.findByBCode(b_code);
		model.addAttribute("RBOOKS",rbList);
		return "rbooks/view";
	}
	
	@RequestMapping(value="/update/{rb_seq}",method=RequestMethod.GET)
	public String update(@PathVariable("rb_seq")long rb_seq,Model model) {
		RBookVO rBookVO = rbService.findBySeq(rb_seq);
		model.addAttribute("rBookVO",rBookVO);
		return "rbooks/update";
	}
	
	@RequestMapping(value="/update/{rb_seq}",method=RequestMethod.POST)
	public String rupdate(@ModelAttribute("rBookVO")RBookVO rBookVO,Model model) {
		int ret = rbService.update(rBookVO);
		return "redirect:/rbook/list";
	}
	
	@RequestMapping(value="/delete/{rb_seq}",method=RequestMethod.GET)
	public String rdelete(@PathVariable("rb_seq") String rb_seq) {
		int ret = rbService.delete(Long.valueOf(rb_seq));
		return "redirect:/rbook/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		RBookVO rBookVO = new RBookVO();
		
		LocalDate localDate = LocalDate.now();
		String curDate = localDate.toString();
		
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.now();
		String curTime = localTime.format(dt).toString();
		
		rBookVO.setRb_date(curDate);
		rBookVO.setRb_stime(curTime);
		
		model.addAttribute("rBookVO",rBookVO);
		return "rbooks/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(RBookVO rBookVO) {
		int ret = rbService.insert(rBookVO);
		return "redirect:/";
	}
	
	
}
