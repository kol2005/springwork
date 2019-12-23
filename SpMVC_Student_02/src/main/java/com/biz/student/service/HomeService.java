package com.biz.student.service;

public class HomeService {

	private String st_home;
	private String st_addr;
	
	public String getSt_home() {
		return st_home;
	}
	public void setSt_home(String st_home) {
		this.st_home = st_home;
	}
	public String getSt_addr() {
		return st_addr;
	}
	public void setSt_addr(String st_addr) {
		this.st_addr = st_addr;
	}

	public void viewHome() {	
		System.out.println(this.st_home);
		System.out.println(this.st_addr);
	}
}
