package com.biz.Hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewString
 */
@WebServlet("/ViewString")
public class ViewString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewString() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> strNames = new ArrayList<String>();
		
		strNames.add("홍길동");
		strNames.add("이몽룡");
		strNames.add("성춘향");
		strNames.add("장영실");
		strNames.add("장녹수");
		strNames.add("장영자");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter wOut = response.getWriter();
		for(String name : strNames) {
			wOut.printf("<p>%s</p>",name);
		}
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
