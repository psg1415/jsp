package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

/***
 * �Խñ� �ۼ� ��Ʈ�ѷ�(����)
 * 
 * GET ���� - �Խñ� �ۼ� ��� (doGet)
 * POST ���� - �Խñ� ��� ó�� (doPost)
 */
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = -1L;
	
	/**
	 * �Խñ� ��� ��� 
	 */
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/board/form.jsp");
		rd.include(request, response);
	}
	
	/**
	 * �Խñ� ���� ó�� 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}