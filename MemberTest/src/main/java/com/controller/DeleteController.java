package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.dao.Member;


public class DeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Member member = new Member();
		String memId = request.getParameter("memId");
		
		boolean result = member.deleteMember(memId);
		System.out.println(result);
		if (result) { // 삭제 성공 -> 메인 /member/main
			response.sendRedirect("main");
			return;
		}
		
		// 삭제실패 -> 메시지
		out.print("<script>alert('삭제 실패!');history.back();</script>");
	}
}