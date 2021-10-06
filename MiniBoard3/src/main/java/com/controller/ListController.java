package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

import com.model.dao.BoardDAO;
import com.model.dto.Board;

public class ListController extends HttpServlet {

	private static final long serialVersionUID = -1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<Board> list = dao.getList();
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
		rd.include(request, response);
	}
}