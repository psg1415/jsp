<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="member" class="com.dto.MemberBean" />
<jsp:setProperty name="member" property="id" value="20210929" />
<jsp:setProperty name="member" property="name" value="이름1" />
아이디 : <jsp:getProperty name="member" property="id" /><br>
이 름 : <jsp:getProperty name="member" property="name" />