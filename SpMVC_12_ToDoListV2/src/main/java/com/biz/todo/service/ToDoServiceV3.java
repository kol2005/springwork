package com.biz.todo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;

@Service("todoV3")
public class ToDoServiceV3 extends ToDoServiceV2 {

	@Override
	public ToDoList findBySeq(long tdSeq) {
		return toDao.findBySeq(tdSeq);
	}

	@Override
	public List<ToDoList> findBySubject(String tdSubject) {
		return toDao.findBySubject(tdSubject);
	}

	@Override
	public int update(ToDoList todoList) {
		return toDao.update(this.procToDoList(todoList));
		
	}

	@Override
	public int insert(ToDoList todoList) {
		return toDao.insert(this.procToDoList(todoList));
	}

	protected ToDoList procToDoList(ToDoList todoList) {
		String td_date = todoList.getTd_date();
		String td_time = todoList.getTd_time();
		String td_complete = todoList.getTd_complete();
		String td_alam = todoList.getTd_alam();
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		if(td_date == null || td_date.isEmpty()) td_date = sd.format(date);
		if(td_time == null || td_time.isEmpty()) td_time = st.format(date);
		if(td_complete == null || td_complete.isEmpty()) td_complete = "N";
		if(td_alam == null || td_alam.isEmpty()) td_alam = "N";
		
		todoList.setTd_date(td_date);
		todoList.setTd_time(td_time);
		todoList.setTd_complete(td_complete);
		todoList.setTd_alam(td_alam);
		
		return todoList;
	}
	
	
}
