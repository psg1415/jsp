package com.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class SiteMain implements Filter {
	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		String filter123 = filterConfig.getInitParameter("filter123");
		System.out.println("filter123 : " + filter123);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher header = request.getRequestDispatcher("../ch00/header.jsp");
		header.include(request, response); // 傈贸府 
		
		chain.doFilter(request, response);
		
		// 饶贸府 
		RequestDispatcher footer = request.getRequestDispatcher("../ch00/footer.jsp");
		footer.include(request, response);
	}
	
	public void destory() {
		System.out.println("destory");
	}
}