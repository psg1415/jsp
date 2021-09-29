<%@ page contentType="text/html; charset=utf-8" %>
<%
	String contentType = request.getHeader("Content-Type");
	String host = request.getHeader("Host");
%>
Content-Type : <%=contentType%><br>
Host : <%=host%>