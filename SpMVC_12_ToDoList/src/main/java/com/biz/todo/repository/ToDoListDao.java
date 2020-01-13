package com.biz.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.todo.domain.ToDoList;

public interface ToDoListDao {

	public List<ToDoList> selectAll();
	public int insert(ToDoList todoList);
	public int complete(@Param("tdSeq") long td_seq,@Param("tdComplete") String tdComplete);
	public int alam(@Param("tdSeq") long tdSeq,@Param("tdAlam") String tdAlam);
	
}
