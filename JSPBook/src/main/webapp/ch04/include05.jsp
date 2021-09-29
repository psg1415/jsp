<%@ page contentType="text/html; charset=utf-8" %>
<h1>include05 상단</h1>
<jsp:include page="include06.jsp">
	<jsp:param name="num1" value="100" />
	<jsp:param name="num2" value="200" />
</jsp:include>
<h1>include05 하단</h1>