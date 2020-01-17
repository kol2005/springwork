package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.service.ReadBookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/rbook")
@RestController
public class ReadBookController {

	private final ReadBookService rbService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<ReadBookVO> list(){
		List<ReadBookVO> rBookList = rbService.selectAll();
		return rBookList;
	}
}
