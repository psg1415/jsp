package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.dao.Member;
import com.model.dto.MemberBean;


public class InsertMember extends HttpServlet {
	public static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/insert.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Member member = new Member();
		boolean result = member.insertMember(new MemberBean(request));
		if (result) {
			// 메인 페이지로 이동
			response.sendRedirect("main");
			return;
		}
		
		// 실패 메세지
		out.print("<script>alert('회원 추가 실패!');history.back();</script>");
		
	}
}