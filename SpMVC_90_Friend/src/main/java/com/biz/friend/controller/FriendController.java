package com.biz.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.service.FriendService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/friend")
@Controller
public class FriendController {

	private final FriendService fService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<FriendVO> fList = fService.selectAll();
		model.addAttribute("FRIENDLIST",fList);
		return "home";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(@ModelAttribute("fVO")FriendVO fVO,Model model) {
		fVO = fService.findById(fVO.getF_id());
		model.addAttribute("VIEW",fVO);
		return "friend/view";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(FriendVO fVO, Model model) {
		model.addAttribute("fVO",fVO);
		return "friend/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String finsert(FriendVO fVO,Model model) {
		int ret = fService.insert(fVO);
		return "redirect:/friend/list";
	}
	/*
	@RequestMapping(value="/update/{f_id}",method=RequestMethod.GET)
	public String update(@PathVariable("f_id")long f_id,Model model) {
		FriendVO fVO = fService.findById(f_id);
		model.addAttribute("fVO",fVO);
		return "friend/update";
	}
	*/
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@ModelAttribute("fVO")FriendVO fVO,Model model) {
		fVO = fService.findById(fVO.getF_id());
		model.addAttribute("fVO",fVO);
		return "friend/update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute FriendVO fVO) {
		int ret = fService.update(fVO);
		return "redirect:/friend/list";
	}
	
	@RequestMapping(value="/search/{f_name}",method=RequestMethod.GET)
	public String search(@PathVariable("f_name")String f_name,Model model) {
		List<FriendVO> fList = fService.findBySearch(f_name);
		model.addAttribute("SEARCH",fList);
		return "friend/search";
	}
	
	@RequestMapping(value="/delete/{f_id}",method=RequestMethod.GET)
	public String delete(@PathVariable("f_id")String f_id) {
		int ret = fService.delete(Long.valueOf(f_id));
		return "redirect:/friend/list";
	}
}
