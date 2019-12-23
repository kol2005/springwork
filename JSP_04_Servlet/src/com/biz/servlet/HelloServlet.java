package com.biz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
/*
 * id값은 현재 프로젝트에서 유일한 값
 * 경우에 따라서 /main_path/sub_path/
 * path를 다중으로 설정할수도 있다
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// jsp의 input box(st_name)에 담겨온 문자열을 추출하여
		// st_name 변수에 담기
		//String st_name = request.getParameter("st_name");
		//System.out.println(st_name);
		
		String st_name = request.getParameter("st_name");
		String st_dept = request.getParameter("st_dept");
		String st_grade = request.getParameter("st_grade");
		
		// web에 문자열을 보낼때 한글(영어이외)문자의 encoding 설정
		response.setContentType("text/html;charset=UTF-8");
		
		// server에서 web으로 데이터를 return 하는 통로 오픈
		//PrintWriter wOut = response.getWriter();
		//wOut.println(st_name);
		//wOut.close();
		
		// web 화면에 어떤 데이터를 표시하는 것이 아니고
		// webcontent/jello.jsp 파일을 열어서
		// web으로 전송하라
		String sendString = "?st_name=" + URLEncoder.encode(st_name,"UTF-8");
		sendString += "&st_dept=" + URLEncoder.encode(st_dept,"UTF-8");
		sendString += "&st_grade=" + URLEncoder.encode(st_grade,"UTF-8");
		
		response.sendRedirect("/JSP_04_Servlet/view.jsp" + sendString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
