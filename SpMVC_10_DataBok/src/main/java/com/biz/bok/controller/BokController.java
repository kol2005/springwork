package com.biz.bok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.bok.domain.BokDetailVO;
import com.biz.bok.domain.BokListVO;
import com.biz.bok.domain.BokSearchDTO;
import com.biz.bok.service.BokDetailService;
import com.biz.bok.service.BokListService;
import com.biz.bok.service.CodeService;

import lombok.extern.slf4j.Slf4j;

/*
 * 1.
 * 기억장치 어딘가에 bokSearchDTO 라는 객체저장공간을 만들고
 * 그 공간을 session에 등록하여 
 * controller, jsp에서 공통으로 접근할수 있도록 설정하라
 * 
 * session에 등록한다
 * 서버의 기억장치에 저장하여
 * 클라이언트(web browser)와 서버간에 연결이 끊기더라도
 * 데이터를 참조할수 있도록 하라
 * 
 * HTTP 프로토콜의 성질
 * web form에 입력된 data ==> server 전송되고나면
 * 그 데이터는 공중으로 사라진다.
 * server ==> web browser에 어떤 결과를 보내고나면
 * 마찬가지로 데이터는 사라지고, 연결도 모두 종료된다.
 * 
 * 하지만
 * web == server 간에 어떤 데이터를 일정하게 유지하고 싶을때가 있다
 * (login 등)
 * 이럴때는 session이라는 공간에 데이터를 저장해두면 
 * web == server가 이 데이터에 접근할수 있다
 * 
 * session은
 * web == server가 공유하는 데이터이다 라고 표현하기도 한다
 */
/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Slf4j
@SessionAttributes("bokSearchDTO")
@Controller
public class BokController {

	@Autowired
	CodeService cService;
	
	@Autowired
	BokListService blService;
	
	@Autowired
	BokDetailService bdService;
	/*
	 * SessionAttributes에 등록된 객체변수는
	 * 현재 controller내에서 반드시 생성하는 method가 있어야한다
	 */
	@ModelAttribute("bokSearchDTO")
	public BokSearchDTO BokSearchDTO() {
//		BokSearchDTO bkDTO = BokSearchDTO.builder()
//				.searchWrd("고용정책")
//				.build();
		
		return blService.getDefaultSearch();
	}
	
	/*
	 * web에서 search를 req하면 
	 * 매개변수 bokSearchDTO를 어딘가로부터 받아야하는데 
	 * 최초에는 아무도 이 값이 없는 상태로 search를 호출한다
	 * 
	 * 이럴경우 bokSearchDTO() method가 자동으로 호출되어
	 * bokSearchDTO 객체를 사용할수 있도록 초기화 생성을 준다
	 */
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String search(@ModelAttribute("bokSearchDTO")BokSearchDTO bokSearchDTO, Model model) {
		
		model.addAttribute("bokSearchDTO", bokSearchDTO);
		model.addAttribute("SeMap",cService.getSelectMaps());
		
		
		return "home";
	}
	
	
	@RequestMapping(value="search",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String search(@ModelAttribute("bokSearchDTO")BokSearchDTO bokSearchDTO, Model model, String strDumy) {
		
		//bokSearchDTO.setSearchWrd("청년정책");
		
		model.addAttribute("bokSearchDTO", bokSearchDTO);
		model.addAttribute("SeMap",cService.getSelectMaps());
		
		List<BokListVO> bokList = blService.getRestResult(bokSearchDTO);
		
		log.debug("결과물:"+bokList);
		//return bService.getRestResult(bokSearchDTO);
		//return "home";
		
		model.addAttribute("BOK_LIST",bokList);
		return "home";
	}
	
	
	@RequestMapping(value="searchAPI",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String searchAPI(@ModelAttribute("bokSearchDTO")BokSearchDTO bokSearchDTO, Model model, String strDumy) {
		
		//bokSearchDTO.setSearchWrd("청년정책");
		
		model.addAttribute("bokSearchDTO", bokSearchDTO);
		model.addAttribute("SeMap",cService.getSelectMaps());
		
		List<BokListVO> bokList = blService.getRestResult(bokSearchDTO);
		
		log.debug("결과물:"+bokList);
		//return bService.getRestResult(bokSearchDTO);
		//return "home";
		
		model.addAttribute("BOK_LIST",bokList);
		return "BokList";
	}
	
	
	@RequestMapping(value="detail",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public String detail(@RequestParam("id") String servId,Model model) {
		
		BokDetailVO bokDetail = bdService.getRestResult(servId);
		model.addAttribute("detail",bokDetail);
		log.debug("DETAIL : " + bokDetail);
		
		return "BokDetail";
	}
}
