package com.biz.student.domain;

public class StudentDTO {

	private String st_num;
	private String st_name;
	private String st_dept;
	private int st_grade;
	private String st_tel;
	
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(String st_num, String st_name, String st_dept, int st_grade, String st_tel) {
		super();
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_dept = st_dept;
		this.st_grade = st_grade;
		this.st_tel = st_tel;
	}
	public String getSt_num() {
		return st_num;
	}
	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_dept() {
		return st_dept;
	}
	public void setSt_dept(String st_dept) {
		this.st_dept = st_dept;
	}
	public int getSt_grade() {
		return st_grade;
	}
	public void setSt_grade(int st_grade) {
		this.st_grade = st_grade;
	}
	public String getSt_tel() {
		return st_tel;
	}
	public void setSt_tel(String st_tel) {
		this.st_tel = st_tel;
	}
	@Override
	public String toString() {
		return "StudentDTO [st_num=" + st_num + ", st_name=" + st_name + ", st_dept=" + st_dept + ", st_grade="
				+ st_grade + ", st_tel=" + st_tel + "]";
	}
	
}
