package com.biz.memo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/idcheck",method=RequestMethod.GET)
	public String userIdCheck(String u_id, Model model) {
		
		/*
		 * idYes : true : 등록된 회원id가 있다
		 * 			false : 아직 등록된 회원id가 없다
		 */
		boolean idYes = uService.userIdCheck(u_id);
		model.addAttribute("ID_YES",idYes);
		model.addAttribute("u_id",u_id);
		return "user/idcheck";
	}
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	/*
	 * @RequestParam(value="strText",required = false, defaultValue = "KOREA") String ss
	 * 매개변수 이름과 상관없이 query로 전달되는 strText 변수를 사용하겠다
	 * ss = strText
	 * 
	 * required = false (※절대 DTO,VO에는 설정 금지!!※)
	 * 사용자가 strText에 값을 전달하지 않아도 400 오류를 내지마라
	 * 
	 * defaultValue = "KOREA"
	 * 사용자가 strText 값을 전달하지 않으면
	 * ss = strText = "KOREA" 라는 기본문자열을 변수에 받아라
	 */
	/*
	 * @ResponseBody
	 * method가 return 하는 문자열을
	 * ResolverView에게 보내서 *.jsp 파일과 렌더링 하는 일을 하지 마라
	 * 문자열을 있는 그대로 브라우저로 보내라
	 * @ResponseBody 없으면
	 * 통상 /views/*.jsp 파일을 렌더링하여 브라우저로 전송하라
	 */
	@ResponseBody
	@RequestMapping(value="/pass",method=RequestMethod.GET)
	public String passwordTest(@RequestParam(value="strText",required = false, defaultValue = "KOREA") String strText) {
		String cryptTest = passwordEncoder.encode(strText);
		long textLeng = cryptTest.length();
		
		return cryptTest + " : " + textLeng;
	}
}
