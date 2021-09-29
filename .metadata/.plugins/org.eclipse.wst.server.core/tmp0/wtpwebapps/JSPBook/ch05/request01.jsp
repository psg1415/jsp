<%@ page contentType="text/html; charset=utf-8" %>
<form method="post" action="request01_process.jsp">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="password"><br>
	회원명 : <input type= "text" name="name"><br>
	취미 : <input type="checkbox" name="hobby" value="등산">등산 /
		  <input type="checkbox" name="hobby" value="수영">수영 /
		  <input type="checkbox" name="hobby" value="독서">독서
	<br>
	<input type="submit" value="입력">
</form>