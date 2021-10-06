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

/**
 *  사이트 전역 필터
 * 
 */
public class SiteMainFilter implements Filter {
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	
		String method = null;
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest)request;
			method = req.getMethod().toUpperCase();
		}
		
		if (method != null && method.equals("GET")) {
			RequestDispatcher header = request.getRequestDispatcher("/outline/header.jsp");
			header.include(request, response);
		}
		
		chain.doFilter(request, response);
		
		if (method != null && method.equals("GET")) {
			RequestDispatcher footer = request.getRequestDispatcher("/outline/footer.jsp");
			footer.include(request, response);
		}
	}
}