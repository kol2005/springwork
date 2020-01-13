package com.biz.todo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repository.ToDoListDao;

@Service("toServiceV1")
public class ToDoServiceV1 implements ToDoService {

	@Autowired
	protected ToDoListDao toDao;
	
	@Override
	public List<ToDoList> selectAll() {
		// TODO Auto-generated method stub
		return toDao.selectAll();
	}
	
	@Override
	public int insert(ToDoList todoList) {
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);// 문자열형 날짜 생성
		String curTime = st.format(date);// 문자열형 시간 생성
		
		/*
		String strTdComp = todoList.getTd_complete();
		if(strTdComp == null || strTdComp.isEmpty()) {
			todoList.setTd_complete("N");
		}
		String strTdAlam = todoList.getTd_alam();
		if(strTdAlam == null || strTdAlam.isEmpty()) {
			todoList.setTd_alam("N");
		}
		*/
		
		//todoList.setTd_date(curDate);
		//todoList.setTd_time(curTime);
		int ret = toDao.insert(todoList);
		
		return ret;
	}

	@Override
	public ToDoList findBySeq(long tdSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToDoList> findBySubject(String tdSubject) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int update(ToDoList todoList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long tdSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int complete(String strSeq,String tdComplete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alam(String strSeq, String tdAlam) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
