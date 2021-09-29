<%@ page contentType="text/html; charset=utf-8" %>
<%
	/**
	* _jspService(HeepServletRequest request, HttpServletResponse response)
	*
	*/
	
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
%>
<%=num1%> + <%=num2%> = <%=(num1 + num2)%>