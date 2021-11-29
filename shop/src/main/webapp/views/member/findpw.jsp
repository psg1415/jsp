<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="find2">
	<div><br><br>
		<input type="text" name="memId" placeholder="아이디"><br><br>
		<input type="text" name="memNm" placeholder="회원명"><br><br>
		<input type="text" name="memPwHint" placeholder="비밀번호 찾기 힌트"><br><br>
		<input class="c" type="submit" value="비밀번호 찾기" style="padding: 0;"><br><br>
	</div>
	<div>
		<a href='./findid'>아이디 찾기</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href='./login'>로그인</a>
	</div>
</div>