package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.dao.BoardDAO;

public class DeleteController extends HttpServlet {
	
	private static final long serialVersionUID = -1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (request.getParameter("idx") == null) {
			out.print("<script>alert('잘못된 방식으로 접근하셨습니다.');history.back();</script>");
			return;
		}
		
		BoardDAO dao = new BoardDAO();
		int idx = Integer.parseInt(request.getParameter("idx"));
		boolean result = dao.delete(idx);
		if (result) { // 삭제 성공 -> 목록으로 이동
			response.sendRedirect("list");
		} else { // 삭제 실패 -> 메세지 -> 뒤로 가기 
			out.print("<script>alert('삭제 실패!');history.back();</script>");
		}
		
	}
}
