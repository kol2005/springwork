package com.biz.todo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.todo.domain.ToDoList;
/*
 * 인터페이스를 왜 사용하는가
 * 1. 어떤 서비스를 구현할 것인가의 설계도
 * 2. 여러 팀원이 분담하여 프로젝트를 구현할때
 * 		꼭 필요한 method를 빼먹지 않고 구현할수 있도록 하는 Guide 역할
 * 3. 자바의 다형성 원리를 이용하여, 버전업(Upgrade)를 했을때
 * 		기존의 사용하던 코들르 최소한으로 변경하여 효과를 낼수 있도록 하는 목적
 * 4. 클래스를 상속받을때 코드가 난해해지는 것을 방지하기도 하며
 * 5. 클래스와 클래스 사이에서 서로 연관도를 낮추어 유연한 관계를 설정하기도 한다
 * 6. 인터페이스는 기획자, PM 등이 미리 설정을 해 두어야 한다
 */
public interface ToDoService {

	public List<ToDoList> selectAll();
	public ToDoList findBySeq(long tdSeq);
	public List<ToDoList> findBySubject(String tdSubject);
	
	public int insert(ToDoList todoList);
	public int update(ToDoList todoList);
	public int delete(long tdSeq);
	public int complete(String strSeq, String tdComplete);
	public int alam(String strSeq, String tdAlam);
	
	
}
