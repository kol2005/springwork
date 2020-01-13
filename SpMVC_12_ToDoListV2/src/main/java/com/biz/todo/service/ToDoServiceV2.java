package com.biz.todo.service;

import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;

@Service("toServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1{

	
	@Override
	public int complete(String strSeq,String tdComplete) {
		long tdSeq = Long.valueOf(strSeq);
		
		tdComplete = tdComplete.equalsIgnoreCase("Y") ? "N" : "Y";
		
		return toDao.complete(tdSeq);
	}

	@Override
	public int update(ToDoList todoList) {

		return toDao.update(todoList);
	}

	@Override
	public int delete(long tdSeq) {
		return toDao.delete(tdSeq);
	}

	@Override
	public int alam(String strSeq, String tdAlam) {
		long tdSeq = Long.valueOf(strSeq);
		
		tdAlam = tdAlam.equalsIgnoreCase("Y") ? "N" : "Y";
		
		return toDao.alam(tdSeq);
	}
	
	

	
}
