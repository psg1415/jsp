<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%
	Enumeration<String> headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()){
		String name = headerNames.nextElement();
		String value = request.getHeader(name);
		
		out.print(name + " = " + value + "<br>");
	}
%>