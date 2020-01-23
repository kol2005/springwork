package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.service.BookService;

import lombok.extern.slf4j.Slf4j;

// @SessionAttributes("booksVO")
@Slf4j
@RequestMapping(value="/books")
@Controller
public class BookController {

	@Autowired
	BookService bService;
	
	@ModelAttribute("booksVO")
	public BooksVO newBooksVO() {
		return new BooksVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<BooksVO> bookList = bService.selectAll();
		model.addAttribute("bookList",bookList);
		return "book";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@RequestParam(value="strText",required = false,defaultValue = "")String strText,Model model) {
		List<BooksVO> bookList = bService.findByBNames(strText);
		model.addAttribute("BLIST",bookList);
		return "book";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "books/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String binsert(BooksVO booksVO,
			Model model) {
		//BooksVO bookVO = (BooksVO)httpSession.getAttribute("booksVO");
		//model.addAttribute("bookVO",booksVO);
		
		int ret = bService.insert(booksVO);
		
		return "redirect:/books/list";
	}
	
	@RequestMapping(value="/bookinfo",method=RequestMethod.GET)
	public String bookinfo(@RequestParam("id") String b_code, Model model) {
		
		BooksVO booksVO = bService.findByBCode(b_code);
		
		model.addAttribute("booksVO",booksVO);
		return "books/update";
	}
	@RequestMapping(value="/bookinfo",method=RequestMethod.POST)
	public String bookupdate(@ModelAttribute("booksVO")BooksVO booksVO, Model model) {
		
		int ret = bService.update(booksVO);
		
		return "redirect:/books/list";
	}
	
	
	//@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("b_code") String b_code,SessionStatus status,Model model) {
		//int ret = bService.delete(Long.valueOf(booksVO.getB_code()));
		int ret = bService.delete(b_code);
		status.setComplete();
		//return "redirect:/books/list";
		return "redirect:/books/list";
	}
	
}
