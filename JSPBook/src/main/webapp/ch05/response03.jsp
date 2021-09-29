<%@ page contentType="text/html; charset=utf-8" %>
<%
	response.setCharacterEncoding("UTF-8");
	response.setHeader("test123", "test123");
	
	Cookie cookie1 = new Cookie("test1", "test123");
	response.addCookie(cookie1);
	
	Cookie cookie2 = new Cookie("test2", "test456");
	response.addCookie(cookie2);
	
	
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		String name = cookie.getName();
		String value = cookie.getValue();
		out.print("name = " + name + ", value = " + value + "<br>");
	}
	
%>