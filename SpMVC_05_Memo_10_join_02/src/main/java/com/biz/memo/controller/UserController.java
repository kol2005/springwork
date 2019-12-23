package com.biz.memo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {

	// UserService uService = new UserServiceImp();
	@Autowired
	UserService uService;
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		/*
		 * insert.jsp 에서 spring form tag를 사용하면서
		 * modelAttribute를 설정해 두었는데 해당 Attribute를 전달해주지 않으면
		 * form을 열때 오류가 발생을 한다.
		 * 때문에 비어있는 (초기화만된) userDTO를 model에 실어서 렌더링에 보낸다.
		 */
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO",userDTO);
		model.addAttribute("BODY","JOIN");
		
		return "user/insert";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bResult, Model model) {
		
		if(bResult.hasErrors()) {
			return "user/insert";
		}else {
			int ret = uService.userJoin(userDTO);
			return "redirect:/memo/list";	
		}
		
	}
	
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mepage(Model model,HttpSession httpSession) {
		
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("userDTO");
		model.addAttribute("userDTO",userDTO);
		model.addAttribute("TITLE","회원정보 수정");
		
		return "user/insert";
	}
	
}
