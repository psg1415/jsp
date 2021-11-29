<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String rootURL = (String)request.getAttribute("rootURL");
	String naverCodeURL = (String)request.getAttribute("naverCodeURL");
%>
<div class="login">
<h2 style="text-align: center;">로그인</h2>
	<form name="frmLogin" id="frmLogin" method="post" action="${rootURL}/member/login" target="ifrmHidden" class="loginFrm">
		<input type="text" name="memId" placeholder="아이디"><br><br>
		<input type="password" name="memPw" placeholder="비밀번호"><br><br>
		<input class="c" type="submit" value="로그인" style="padding: 0;">
	</form>
	<div class="aFrm"><br>
		<a href="./findid">아이디 찾기 </a>&nbsp;|&nbsp;
		<a href="./findpw">비밀번호 찾기 </a>&nbsp;|&nbsp;
		<a href="./join">회원가입</a>
	</div><br><br>    
	<div class="sns_btn"><a href=""><img src="${rootURL}/resources/image/kakaologin.png" width="200"></a></div><br>
	<div class="sns_btn"><a href="${naverCodeURL}"><img src="${rootURL}/resources/image/naverlogin.png" width="200"></a></div>
</div>