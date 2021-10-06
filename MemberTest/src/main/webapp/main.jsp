<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList, com.model.dto.MemberBean" %>
<%
	ArrayList<MemberBean> list = (ArrayList<MemberBean>)request.getAttribute("list");
%>
<c:set var="list" value="<%=list%>" />
<table border="1">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>회원명</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="member" items="${list}">
		<tr>
			<td><c:out value="${member.memNo}" /></td>
			<td><c:out value="${member.memId}" /></td>
			<td><c:out value="${member.memNm}" /></td>
			<td>
				<a href="delete?memId=<c:out value="${member.memId}" />" onclick="return confirm('정말 삭제 하시겠습니까?');">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>