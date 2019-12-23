package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;


public class StudentService {

	private String st_name;
	private String st_dept;
	
	public StudentService() {
		// TODO Auto-generated constructor stub
	}
	public StudentService(String st_name, String st_dept) {
		this.st_name = st_name;
		this.st_dept = st_dept;	
	}
	
	public void viewStudent() {
		System.out.println(this.st_name);
		System.out.println(this.st_dept);
	}
	
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
