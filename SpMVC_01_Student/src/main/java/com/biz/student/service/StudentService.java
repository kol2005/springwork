package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;

@Service
public class StudentService {

	public List<StudentDTO> stdList() {
		List<StudentDTO> stdList = new ArrayList<StudentDTO>();
		
		StudentDTO stdDTO = new StudentDTO();
		stdDTO.setSt_num("0001");
		stdDTO.setSt_name("hong");
		stdDTO.setSt_dept("computer");
		stdDTO.setSt_grade(3);
		stdDTO.setSt_tel("001");
		
		stdList.add(stdDTO);
		
		stdDTO = new StudentDTO();
		stdDTO.setSt_num("0002");
		stdDTO.setSt_name("lee");
		stdDTO.setSt_dept("computer");
		stdDTO.setSt_grade(3);
		stdDTO.setSt_tel("010");
		
		stdList.add(stdDTO);
		
		stdDTO = new StudentDTO();
		stdDTO.setSt_num("0003");
		stdDTO.setSt_name("ng");
		stdDTO.setSt_dept("computer");
		stdDTO.setSt_grade(1);
		stdDTO.setSt_tel("010");
		
		stdList.add(stdDTO);
		
		return stdList;
	}
}
