package com.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class SiteMain2 implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher header = request.getRequestDispatcher("../ch00/header2.jsp");
		header.include(request, response); // 傈贸府 
		
		chain.doFilter(request, response);
		
		RequestDispatcher footer = request.getRequestDispatcher("../ch00/footer2.jsp");
		footer.include(request, response); // 饶贸府 
	}
	
	public void destroy() {
		
	}
}