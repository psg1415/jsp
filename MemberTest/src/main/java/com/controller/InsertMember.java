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
			// ���� �������� �̵�
			response.sendRedirect("main");
			return;
		}
		
		// ���� �޼���
		out.print("<script>alert('ȸ�� �߰� ����!');history.back();</script>");
		
	}
}