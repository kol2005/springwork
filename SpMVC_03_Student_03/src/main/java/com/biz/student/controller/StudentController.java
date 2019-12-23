package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.service.StudentService;

@RequestMapping(value="/student")
@Controller
public class StudentController {

	//@Inject : Java EE(EJB)에서 제공하는 기능
	
	@Autowired // : Spring Framework의 고유 기능
	// 이미 생성(초기화)되어서 컨테이너에 보관중인
	// StudentService의 인스턴스를 가져다가 sService를 사용할 수 있도록
	// 만들어주는 역할
	StudentService sService;
	
	/*
	 * StudentService의 getStdList() method를 호출하여
	 * 학정정보가 담긴 List를 가져오고
	 * view 화면에 rendering 할수 있도록 공급하기
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("BODY","STUDENT-LIST");
		List<StudentDTO> stdList = sService.getStdList();
		
		model.addAttribute("STDLIST",stdList);
		
		//return null;// "/student/list.jsp"
		return "home";
	}
}
