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
 *  ����Ʈ ���� ����
 * 
 */
public class SiteMainFilter implements Filter {
	private FilterConfig filterConfig;
	private String[] staticDirs = { "resources" }; // ���� ���丮(���, Ǫ�� ����)
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
		/** ������ ���̽� ���� �ʱ�ȭ */
		DB.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		// ����Ʈ root URL 
		String siteURL = request.getServletContext().getContextPath();
		request.setAttribute("siteURL", siteURL);
		
		// ��� ��� 
		outlineHeader(request, response);
		
		chain.doFilter(request, response);
		
		// Ǫ�� ���
		outlineFooter(request, response);
	}
	
	/**
	 * ���� ��� ó�� 
	 * 
	 * @param request
	 * @param response
	 */
	public void outlineHeader(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (isOutlineRequired(request)) { // ��� �߰� ������ ���� �߰� 
			response.setContentType("text/html; charset=utf-8");
			String headerFile = isPopup(request)?"/outline/popup_header.jsp":"/outline/header.jsp";
			RequestDispatcher header = request.getRequestDispatcher(headerFile);
			header.include(request, response);
		}
	}
	
	/**
	 * ���� Ǫ�� ó�� 
	 * 
	 * @param request
	 * @param response
	 */
	public void outlineFooter(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (isOutlineRequired(request)) { // Ǫ�� �߰������� �� �߰� 
			String footerFile = isPopup(request)?"/outline/popup_footer.jsp":"/outline/footer.jsp";
			RequestDispatcher footer = request.getRequestDispatcher(footerFile);
			footer.include(request, response);
		}
	}
	
	/**
	 * ���, Ǫ�Ͱ� �ʿ����� ���� üũ 
	 * 
	 * @param request
	 * @return
	 */
	public boolean isOutlineRequired(ServletRequest request) {
		/**
		 * 1. GET ����� �ƴ� ��� false (HttpServletRequest - getMethod())
		 * 2. ���� ��ο� �ش��ϴ� URI �� ��� false (HttpServletRequest - getRequestURI())
		 */
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest)request;
			
			/** �޼��尡 GET ����� �ƴ� ��� ���, Ǫ�� ���� */
			String method = req.getMethod().toUpperCase();
			if (!method.equals("GET")) 
				return false;
			
			/** RequestURI�� ���� ���丮�� ���� �Ǿ� ������ ���� */
			String URI = req.getRequestURI();
			for (String dir : staticDirs) {
				if (URI.indexOf("/" + dir) != -1) { // ���� ���丮�� ���Ե� ���
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * �˾� ���������� üũ
	 * 
	 * @param request
	 * @return true - �˾�, false - �Ϲ� ������
	 */
	public boolean isPopup(ServletRequest request) {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest)request;
			String URI = req.getRequestURI();
			if(URI.indexOf("/popup") != -1) { //URI��ο� popup�� ���Ե� ���
				return true;
			}
		}
		
		
		return false;
	}
}