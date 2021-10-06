package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import com.core.FileManager;

/**
 * ���� ���ε� ó��
 * 
 * GET - ���ε� ���
 * POST - ���ε� ó��
 */
public class FileUploadController extends HttpServlet {
	
	private static final long serialVersionUID = -1L;
	
	/**���ε� ���*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/board/upload.jsp");
		rd.include(request, response);
	}
	
	/**���ε� ó��*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uploadedFiles = FileManager.upload(request);
		if(uploadedFiles == null) { //���ε�� ������ ���� ���, �̹��� ������ �ƴ� ���
			out.print("<script>alert('���ε� ����!');</script>");
		}else { //���ε尡 �� ���
			out.print("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>");
			out.printf("<script>parent.parent.callbackUploadImages('%s')</script>", uploadedFiles);
		}
	}
}
