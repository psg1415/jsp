package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.core.Logger;
import com.models.goods.Goods;
import com.models.goods.GoodsDao;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *  /goods/* 컨트롤러
 *
 */
public class GoodsController extends HttpServlet {
	
	private String httpMethod; // Http 요청 메서드, GET, POST
	private PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** 요청 메서드 */
		httpMethod = request.getMethod().toUpperCase();
		if (httpMethod.equals("GET")) {
			response.setContentType("text/html; charset=utf-8");
		} else { // GET이 아닌 경우 -> 유입된 입력 양식 데이터 처리
			response.setCharacterEncoding("utf-8");
		}
		
		out = response.getWriter();

		String URI = request.getRequestURI();
		String mode = URI.substring(URI.lastIndexOf("/") + 1);
		switch(mode) {
			case "add" : // 상품등록
				addController(request, response);
				break;
			case "shoppingbag" : // 장바구니
				shoppingbagController(request, response);
				break;
			default : // 없는 페이지 
				RequestDispatcher rd = request.getRequestDispatcher("/views/error/404.jsp");
				rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 상품 등록 /goods/add
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (httpMethod.equals("GET")) { // 양식 출력
			RequestDispatcher rd = request.getRequestDispatcher("/views/goods/add.jsp");
			rd.include(request, response);
		} else { // 데이터처리(post)
			try {
				GoodsDao dao = GoodsDao.getInstance();
				boolean result = dao.addGoods(request);
				if (!result) {
					throw new Exception("상품등록을 실패하였습니다.");
				}
				out.print("<script>parent.location.reload();</script>");
			} catch (Exception e) {
				Logger.log(e);
				out.printf("<script>alert('%s');</script>", e.getMessage());
			}
		}		
	}
	
	/**
	 * 장바구니 /goods/shoppingbag
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void shoppingbagController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (httpMethod.equals("GET")) { // 양식 출력
			RequestDispatcher rd = request.getRequestDispatcher("/views/goods/add.jsp");
			rd.include(request, response);
		} else { // 데이터처리(post)
			try {
				GoodsDao dao = GoodsDao.getInstance();
				boolean result = dao.addGoods(request);
				if (!result) {
					throw new Exception("상품등록을 실패하였습니다.");
				}
				out.print("<script>parent.location.reload();</script>");
			} catch (Exception e) {
				Logger.log(e);
				out.printf("<script>alert('%s');</script>", e.getMessage());
			}
		}		
	}
}	