<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="member" class="com.dto.MemberBean" />
<%
	member.setId(20210929);
	member.setName("이름1");
%>
아이디 : <%=member.getId()%><br>
이 름 : <%=member.getName()%>