package com.biz.iolist.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.service.IolistService;

@RequestMapping(value="/iolist")
@Controller
public class IolistController {

	@Autowired
	IolistService ioService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String ioHome(Model model) {
		/*
		 *  아직 viewAllList() method를 생성하지 않은 상태에서
		 *  viewAllList() 호출하여 할일을 먼저 정의한 것
		 *  TDD(Test Driven Developer)
		 */
		
		List<IolistVO> iolist = ioService.viewAllList();
		/*
		 * jsp view에서 사용할 변수 역할을 수행할
		 * Attribute를 등록하는 절차이고
		 * 이때 이름 "IOLIST"를 대문자로 사용하는 이유는
		 * 대소문자가 섞이면 문자 차이로인한 오류가 발생하거나
		 * 값을 표시하지 못하는 일이 있는데
		 * 이를 방지하기 위함이다
		 */
		model.addAttribute("IOLIST",iolist);
		return "iolist/list";
	}
	
	// 새로등록 버튼을 클릭했을때 입력 form을 보여주는 method
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String list(Model model) {
		
		/*
		 * 새로입력을 수행할때 Default값을 만들어서 form에 세팅하기
		 */
		// 서버의 현재날짜를 문자열로 생성
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sd.format(date);
		
		// ioDTO를 선언하여 IO_SEQ값과 IO_DATE를 세팅하고
		IolistDTO ioDTO = IolistDTO.builder()
				.io_seq(0)
				.io_date(curDate)
				.build();
		
		// model에 담아서 input.jsp폼에 전송
		model.addAttribute("IO_DTO",ioDTO);
		
		return "iolist/input";
	}
	
	/*
	 * POST에서 데이터를 수신할때 
	 * DTO에 데이터를 받을 경우
	 * DTO의 필드변수중에 String이 아닌 데이터가 있을 경우
	 * 입력폼에서 해당값을 입력하지 않고 전송을하면
	 * 400 오류가 발생을 한다
	 * Type.valueOf() method에서 exception이 발생하기 때문이다
	 * 
	 * 즉, 입력폼에서 String이 아닌 항목을 비워놓고 전송을 하면
	 * 발생하는 오류이다
	 */
	// 입력 form에서 데이터를 입력하고 전송(저장) 버튼을 클릭했을때
	// 데이터를 수신할 method
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String list(IolistDTO ioDTO, Model model) {
		
		int ret = ioService.insert(ioDTO);
		
		// insert(input),update,delete POST를 수행한 후
		// List를 보여서 변경된 사항을 보여줘라
		return "redirect:/iolist/list";
	}
	
	/*
	 * tbl_iolist seq 칼럼은 숫자형인데
	 * 일단 seq 칼럼으로 조회를 하기위한 쿼리값인 id는
	 * 문자열로 받는다
	 * 혹시 id값이 전송되지 않아서 발생할수 있는
	 * 400 오류를 방지하기 위함이다
	 */
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(String id, Model model) {
		
		long io_seq = 0;
		try {
			io_seq = Long.valueOf(id);
		} catch (Exception e) {
			
		}
		IolistVO ioDTO = ioService.findBySeq(io_seq);
		model.addAttribute("IO_DTO",ioDTO);
		return "iolist/view";
	}
	
}
