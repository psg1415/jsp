package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import com.core.Logger;
import com.models.member.Member;
import com.models.member.MemberDao;
import com.models.snslogin.NaverLogin;
import com.models.snslogin.SocialLogin;

import java.io.IOException;
import java.io.PrintWriter;

public class CategoryController extends HttpServlet {
	private String httpMethod; // Http 요청 메서드, GET, POST
	private PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** 요청 메서드 */
		httpMethod = request.getMethod().toUpperCase();
		if (httpMethod.equals("GET")) {
			response.setContentType("text/html; charset=utf-8");
		} else { // GET이 아닌 경우 -> 유입된 입력 양식 데이터 처
			response.setCharacterEncoding("utf-8");
		}
		
		out = response.getWriter();
		


		String URI = request.getRequestURI();
		String mode = URI.substring(URI.lastIndexOf("/") + 1);

		System.out.println("mode = " + mode);
		switch(mode) {
			case "category" : // 카테고리
				RequestDispatcher rd = request.getRequestDispatcher("/views/category/category.jsp");
				rd.include(request, response);
				break;
			case "chicken" : // 닭가슴살
				chickenController(request, response);
				break;
			case "sausage" : // 소세지,핫바
				sausageController(request, response);
				break;
			case "salad" : // 샐러드
				saladController(request, response);
				break;
			case "shake" : // 쉐이크
				shakeController(request, response);
				break;
			default : // 없는 페이지 
				RequestDispatcher rds = request.getRequestDispatcher("/views/error/404.jsp");
				rds.forward(request, response);
		}


		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 닭가슴살 /category/chicken
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void chickenController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (httpMethod.equals("GET")) { // 양식 출력(get) 
			RequestDispatcher rd = request.getRequestDispatcher("/views/category/chicken.jsp");
			rd.include(request, response);
		} else { // 양식 처리(post)
			//CategoryrDao dao = CategoryrDao.getInstance();
			try {
				

			} catch (Exception e) {
				response.setContentType("text/html; charset=utf-8");
				out.printf("<script>alert('%s');</script>", e.getMessage());
				Logger.log(e);
			}
		}
	}
	
	/**
	 * 소세지 /category/sausage
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void sausageController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (httpMethod.equals("GET")) { // 양식 출력(get) 
			RequestDispatcher rd = request.getRequestDispatcher("/views/category/sausage.jsp");
			rd.include(request, response);
		} else { // 양식 처리(post)
			//CategoryrDao dao = CategoryrDao.getInstance();
			try {
				

			} catch (Exception e) {
				response.setContentType("text/html; charset=utf-8");
				out.printf("<script>alert('%s');</script>", e.getMessage());
				Logger.log(e);
			}
		}
	}
	
	/**
	 * 샐러드 /category/salad
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saladController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (httpMethod.equals("GET")) { // 양식 출력(get) 
			RequestDispatcher rd = request.getRequestDispatcher("/views/category/salad.jsp");
			rd.include(request, response);
		} else { // 양식 처리(post)
			//CategoryrDao dao = CategoryrDao.getInstance();
			try {
				

			} catch (Exception e) {
				response.setContentType("text/html; charset=utf-8");
				out.printf("<script>alert('%s');</script>", e.getMessage());
				Logger.log(e);
			}
		}
	}
	
	/**
	 * 쉐이크 /category/shake
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void shakeController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (httpMethod.equals("GET")) { // 양식 출력(get) 
			RequestDispatcher rd = request.getRequestDispatcher("/views/category/shake.jsp");
			rd.include(request, response);
		} else { // 양식 처리(post)
			//CategoryrDao dao = CategoryrDao.getInstance();
			try {
				

			} catch (Exception e) {
				response.setContentType("text/html; charset=utf-8");
				out.printf("<script>alert('%s');</script>", e.getMessage());
				Logger.log(e);
			}
		}
	}		
}