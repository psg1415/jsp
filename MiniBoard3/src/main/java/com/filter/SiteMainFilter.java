package com.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.core.*;

/**
 *  사이트 전역 필터
 * 
 */
public class SiteMainFilter implements Filter {
	private FilterConfig filterConfig;
	private String[] staticDirs = { "resources" }; // 정적 디렉토리(헤더, 푸터 제외)
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
		/** 데이터 베이스 설정 초기화 */
		DB.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		// 사이트 root URL 
		String siteURL = request.getServletContext().getContextPath();
		request.setAttribute("siteURL", siteURL);
		
		// 헤더 출력 
		outlineHeader(request, response);
		
		chain.doFilter(request, response);
		
		// 푸터 출력
		outlineFooter(request, response);
	}
	
	/**
	 * 공통 헤더 처리 
	 * 
	 * @param request
	 * @param response
	 */
	public void outlineHeader(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (isOutlineRequired(request)) { // 헤더 추가 조건일 때만 추가 
			response.setContentType("text/html; charset=utf-8");
			String headerFile = isPopup(request)?"/outline/popup_header.jsp":"/outline/header.jsp";
			RequestDispatcher header = request.getRequestDispatcher(headerFile);
			header.include(request, response);
		}
	}
	
	/**
	 * 공통 푸터 처리 
	 * 
	 * @param request
	 * @param response
	 */
	public void outlineFooter(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (isOutlineRequired(request)) { // 푸터 추가조건일 때 추가 
			String footerFile = isPopup(request)?"/outline/popup_footer.jsp":"/outline/footer.jsp";
			RequestDispatcher footer = request.getRequestDispatcher(footerFile);
			footer.include(request, response);
		}
	}
	
	/**
	 * 헤더, 푸터가 필요한지 여부 체크 
	 * 
	 * @param request
	 * @return
	 */
	public boolean isOutlineRequired(ServletRequest request) {
		/**
		 * 1. GET 방식이 아닌 경우 false (HttpServletRequest - getMethod())
		 * 2. 정적 경로에 해당하는 URI 인 경우 false (HttpServletRequest - getRequestURI())
		 */
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest)request;
			
			/** 메서드가 GET 방식이 아닌 경우 헤더, 푸터 제외 */
			String method = req.getMethod().toUpperCase();
			if (!method.equals("GET")) 
				return false;
			
			/** RequestURI에 정적 디렉토리가 포함 되어 있으면 제외 */
			String URI = req.getRequestURI();
			for (String dir : staticDirs) {
				if (URI.indexOf("/" + dir) != -1) { // 정적 디렉토리가 포함된 경우
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 팝업 페이지인지 체크
	 * 
	 * @param request
	 * @return true - 팝업, false - 일반 페이지
	 */
	public boolean isPopup(ServletRequest request) {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest)request;
			String URI = req.getRequestURI();
			if(URI.indexOf("/popup") != -1) { //URI경로에 popup이 포함된 경우
				return true;
			}
		}
		
		
		return false;
	}
}