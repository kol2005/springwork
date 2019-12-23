package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.service.DeptService;

@RequestMapping(value="/dept")
@Controller
public class DeptController {
	
	// @Inject
	@Autowired
	DeptService dService;

	// class의 /dept와 method /list를 묶어서 
	// /dept/list Path로 request 했을때
	// list() method가 호출된다
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(Model model) {
		
		/*
		 * Model(ui.Model)클래스와 같은 역할을 수행하는 Spring 클래스
		 * 사용법이 조금 다른 형식
		 * 여기에는 view와 객체를 동시에 담아서 
		 * Dispatcher에게 객체를 리턴해주는 형식으로 사용
		 * 
		 * Model은 객체만 담고
		 * view는 문자열을 return하는 방식으로 사용
		 */
		ModelAndView mView = new ModelAndView();
		List<DeptDTO> deptList = dService.getAllList();
		
		// return "/dept/list"와 같은 역할
		mView.setViewName("/dept/list");
		
		// model.addAttribute("DEPTLIST",deptList)와 같은 역할
		mView.addObject("DEPTLIST",deptList);
		
		// return String 이 아닌 ModelAndView 사용
		return mView;
	}
	
}
