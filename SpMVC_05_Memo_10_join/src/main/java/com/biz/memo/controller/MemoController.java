package com.biz.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/memo")
/*
 * SessionAttributes로 설정된 변수(객체)는
 * response를 하기전에 서버의 기억장소 어딘가에 임시로 보관을 해둔다
 * web browser와 server간에 한번이라도 연결이 이루어졌으면
 * Session 에 등록된 변수는 서버가 중단될떄까지 그 값이 그대로 
 * 유지된다
 * web은 클라이언트의 req를 서버가 받아서
 *  res를 수행하고 나면 모든 정보가 사라지는 특성이 있다
 * 이런 특성과는 달리 Spring 기반의 web은 일부 데이터들을
 * 메모리에 보관했다가 재사용하는 기법이 있다
 * 그중 SessionAttributes라는 기능이 있다
 * 
 * SessionAttributes()에 설정하는 문자열(이름)은
 * 클래스의 표준 객체생성 패턴에 의해 만들어진 
 */
@SessionAttributes("memoDTO")
@Controller
public class MemoController {

	/*
	 * SessionAttributes를 사용하기 위해서는
	 * 반드시 해당 변수를 생성하는 method가 controller에 있어야하고
	 * 해당 메서드에는 ModelAttribute("변수명") 가 있어야한다
	 */
	@ModelAttribute("memoDTO")
	public MemoDTO makeMemoDTO() {
		MemoDTO memoDTO = new MemoDTO();
		return memoDTO;
	}
	
	@Autowired
	MemoService mService;
	
	// @GetMapping 5.2 버전부터 지원안함
	// @PostMapping 5.2 버전부터 지원안함
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(String search, Model model) {
		
		List<MemoDTO> memoList;
		if(search == null || search.isEmpty()) {
			memoList = mService.getAllList();
		}else {
			memoList = mService.getSearchList(search);
		}
		/*
		List<MemoDTO> memoList = mService.getAllList();
		for(MemoDTO m: memoList) {
			log.debug(m.toString());
		}
		*/
		model.addAttribute("MEMO_LIST",memoList);
		
		return "home";
	}
	
	/*
	 * SessionAttributes에서 설정한 변수(객체)에는
	 * @ModelAttribute를 설정해 두어야 한다
	 * 단, 5.x 이하에서는 필수 5.x 이상에서는 선택
	 * 
	 * 만약 Attributes의 이름을 표준패턴이 아닌 임의의 이름으로 사용할경우
	 * @ModelAttribute("객체이름")을 필수로 지정해 주어야 한다
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("memoDTO") MemoDTO memoDTO, Model model,HttpSession httpSession) {
		
		UserDTO userDTO = (UserDTO)httpSession.getAttribute("userDTO");
		
		if(userDTO == null){
			model.addAttribute("LOGIN_MSG","TRY");
			return "redirect:/member/login";
		}
			
		model.addAttribute("memoDTO",memoDTO);
		return "insert";
	}
	
	/*
	 * insert POST가 memoDTO를 수신할때
	 * 입력 form에서 사용자가 입력한 값들ㅇ ㅣ있으면
	 * 그 값들을 memoDTO의 필드변수에 setting을 하고
	 * 만약 없으면
	 * 메모리 어딘가에 보관중인 SessionAttributes로 설정된
	 * memoDTO변수에서 값을 가져와서 비어있는
	 * 필드변수를 채워서 매개변수에 주입한다
	 * 
	 * 따라서 form에서 보이지 않아도 되는 값들은
	 * 별도의 코딩을 하지 않아도
	 * 자동으로 insert POST로 전송되는 효과를 낸다
	 * 단, 이 기능을 효율적으로 사용하려면 
	 * jsp코드에서 Spring-form tag로 input 를 코딩해야 한다
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("memoDTO") MemoDTO memoDTO, String search, Model model,SessionStatus sessionStatus) {
		
		log.debug("시퀀스 : " + memoDTO.getM_seq());
		log.debug("날짜 : " + memoDTO.getM_date());
		log.debug("text : " + memoDTO.getM_text());
		
		int ret = mService.insert(memoDTO);
		
		// SessionAttributes를 사용할때 insert, update가 완료되고
		// view 로 보내기전 반드시 setComplet()를 실행하여
		// session 에 담긴
		sessionStatus.setComplete();
		
		return "redirect:/memo/list";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(@RequestParam("id") String str_seq, @ModelAttribute MemoDTO memoDTO, Model model, HttpSession hSession) {
		
		long m_seq = 0;
		try {
			m_seq = Long.valueOf(str_seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		memoDTO = mService.getMemo(m_seq);
		
		UserDTO userDTO = (UserDTO)hSession.getAttribute("userDTO");
		
		// 로그인한 id와 메모의 m_auth 값을 비교하여
		// 작성자가 아니면 로그인 창으로 건너뛰기
		if(userDTO != null && userDTO.getU_id().equals(memoDTO.getM_auth())) {
			model.addAttribute("memoDTO",memoDTO);
			return "view";	
		}else {
			model.addAttribute("LOGIN_MSG","NO_AUTH");
			return "redirect:/member/login";
		}
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id, @ModelAttribute MemoDTO memoDTO, Model model) {
		long m_seq = 0;
		try {
			m_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		memoDTO = mService.getMemo(m_seq);
		model.addAttribute("memoDTO",memoDTO);
		return "insert";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute MemoDTO memoDTO, Model model,SessionStatus sessionStatus) {
		int ret = mService.update(memoDTO);
		return "redirect:/memo/list";
	}
	
	/*
	 * 브라우저에서 delete를 호출할때
	 * m_seq변수에 값을 포함하지 않고 req 보내면
	 * 서버에서는 400 오류가 발생을 한다
	 * 그 이유는 Spring web 에서 넘겨져 온 데이터를
	 * long형으로 형변환을 수행하여 값을 받으려고 시도를 한다
	 * 그 과정에서 값이 없으면 null 을 long으로 변환하는 코드가
	 * 실행되어 서버내부에서 exception이 발생하고
	 * 400 오류를 web에게 알려주게 된다
	 * 
	 * 이것을 방지하기 위해 String 으로 일단 받고
	 * 별도로 Long.valueOf() 를 실행하는 코드가 안전하다
	 * 
	 * 하지만 delete를 호출할때
	 * 절대!! m_seq이 없게는 호출되지 않는다는 가정하에 
	 * 바로 long 형의 변수로 수신할수 있다
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@ModelAttribute MemoDTO memoDTO) {
		int ret = mService.delete(memoDTO.getM_seq());
		return "redirect:/memo/list";
	}
	
}
