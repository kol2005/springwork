package com.biz.Hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/come")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 지금부터 browser로 전송되는 데이터는
		// text/html 문서이다
		// 한글은 UTF-8 방식으로 encoding 해서 취급하라
		response.setContentType("text/html;charset=UTF-8");
		
		// response 객체는 Server에서 WebBrowse 로 연결되는 통로와 정보를
		// 가지고 있다
		// response 로 부터 writer 객체를 요청을 하는데
		// 이 writer 객체는 서버에서 어떤 데이터를 WebBrowser로 보내는
		// 통로로 사용이 된다
		PrintWriter wOut = response.getWriter();
		wOut.println("<body>");
		wOut.println("<h3>우리집에 오신것을 환영합니다</h3>");
		wOut.println("<p>나는 Servlet에서 보내는 메시지 입니다</p>");
		
		wOut.println("<body>");
		wOut.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
