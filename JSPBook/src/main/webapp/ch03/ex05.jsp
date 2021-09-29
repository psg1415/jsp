<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="i" begin="1" end="9" step="1">
	<h1>${i}단</h1>
	<c:forEach var="j" begin="1" end="9">
		${i} X ${j} = ${i * j}<br>
	</c:forEach>
</c:forEach>