package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.dao.BoardDAO;

/***
 * 게시글 작성 컨트롤러(서블릿)
 * 
 * GET 접근 - 게시글 작성 양식 (doGet)
 * POST 접근 - 게시글 등록 처리 (doPost)
 */
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = -1L;
	
	/**
	 * 게시글 양식 출력 
	 */
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/board/form.jsp");
		rd.include(request, response);
	}
	
	/**
	 * 게시글 저장 처리 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		BoardDAO dao = new BoardDAO();
		int idx = dao.write(request);
		if (idx > 0) { // 게시글 등록 성공 -> 게시글 보기 페이지로 이동 
			out.print("<script>parent.location.href='view?idx="+ idx + "';</script>");
		} else { // 게시글 등록 실패
			out.print("<script>alert('게시글 등록 실패!');</script>");
		}
	}
}
