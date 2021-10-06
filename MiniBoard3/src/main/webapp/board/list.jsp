<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.dto.Board" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
<c:set var="list" value="<%=list%>" />
<h1>게시판 목록</h1>
<ul>
<c:forEach var="board" items="${list}">
	<li>
		<a href='view?idx=${board.idx}'>
			${board.subject}  / ${board.poster} / ${board.regDt}
		</a>
	</li>
</c:forEach>
</ul>
<a href='write'>글 쓰기</a>