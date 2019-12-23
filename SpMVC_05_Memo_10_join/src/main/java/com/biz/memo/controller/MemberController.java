package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.memo.domain.UserDTO;

/*
 * Controller에서 객체(리스트)를 view로 보내는 방법
 * Model(ModelAndView).addAttribute()
 * SessionAttributes() ModelAndAttribute() 설정후 Model에 담기
 * HttpSession.setAttribute()에 담기
 * 
 * Model : 일회용데이터 Controller >> view 보내기만을 위한 데이터
 * 			Model에 담긴 데이터를 다시 server로 보내려면
 * 			input tag에 값을 담아서 다시 POST로 전송
 * SessionAttributes + Model : 일회용데이터이면서 session에 유지되는 데이터
 * 								input view에서 Spring form tag에 값을 담으면
 * 								이후에 자유롭게 서버로 전송을 할 수 있다.
 * 								input,update 코딩을 간편하게 사용하는 용도
 * HttpSession : 주로 login과 관련된 데이터를 유지하기 위한 용도
 * 					특별히 시간설정을 하거나, 값을 remove하거나 서버가 멈출때까지
 * 					그 값을 유지하고 모든 controller, 모든 view에서 값을 참조할수 있다
 * 					서버의 메모리공간을 많이 차지하여 서버 성능에 문제를 일으키기도 한다
 * 					GC(Gabage Collection)을 적용할수 없다.
 * 					표준 HTTP 프로토콜에 정의된 규격을 사용한다.
 */

@RequestMapping(value="/member")
@Controller
public class MemberController {
	
	/*
	 * 1. DB에 사용자 저장하기
	 * 2. password 부분을 암호화하기
	 * 3. spring form tag를 활용한 유효성검사
	 */

	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@RequestParam(value="LOGIN_MSG",required = false, defaultValue = "0") String msg, Model model) {
		model.addAttribute("LOGIN_MSG",msg);
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserDTO userDTO, Model model, HttpSession httpSession) {
		
		// DB에서 데이터를 가져온 사용자 정보
		UserDTO getUserDTO = UserDTO.builder()
				.u_id("kol2005")
				.u_password("12345")
				.u_name("개돼지")
				.u_tel("꿀꿀꿀꿀꿀꿀꿀꿀")
				.build();
		
		// 로그인한 사용자 ID와 password를 DB정보화 일치하는 검사
		if(userDTO.getU_id().equalsIgnoreCase(getUserDTO.getU_id()) 
				&& userDTO.getU_password().equals(getUserDTO.getU_password())) {
			
			// 시간제한용 코드 (10*60초) 후에 메모리 삭제
			httpSession.setMaxInactiveInterval(10*60);
			httpSession.setAttribute("userDTO", getUserDTO);
		}else {
			httpSession.removeAttribute("userDTO");
		}
		
		return "redirect:/memo/list";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		httpSession.setAttribute("userDTO", null);
		httpSession.removeAttribute("userDTO");
		return "redirect:/memo/list";
	}
}
