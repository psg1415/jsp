package com.controller.board;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = -1079492929715019421L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String test1 = getServletConfig().getInitParameter("test1");
		String test2 = getServletConfig().getInitParameter("test2");
		System.out.println("test1 : " + test1);
		System.out.println("test2 : " + test2);
		
		//RequestDispatcher header = request.getRequestDispatcher("../ch00/header.jsp");
		//header.include(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("../ch00/list.jsp");
		rd.include(request, response);
		
		//RequestDispatcher footer = request.getRequestDispatcher("../ch00/footer.jsp");
		//footer.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}