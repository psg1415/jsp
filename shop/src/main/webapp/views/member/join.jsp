<%@ page contentType="text/html; charset=utf-8" %>


<form action="" class="joinFrm">
	<div class="join">
		<h2 style="text-align: center;">회원가입 </h2>
		<input type="text" name="memId" placeholder="아이디"><br><br>
		<input type="password" name="memPw" placeholder="비밀번호"><br><br>
		<input type="password" name="memPw" placeholder="비밀번호 확인"> <br><br>
		<input type="text" name="memPwHint" placeholder="비밀번호 힌트"> <br><br>
		<input type="text" name="name" maxlength="20" placeholder="이름"> <br><br>
		<input type="text" name="email" placeholder="이메일"><br><br>
		<input type="text" name="address" placeholder="주소"> <br><br>
		<input class="c" type="submit" value="회원가입" style="padding: 0;"><br><br>
		<input class="c" type="button" value="취소" style="padding: 0;" onClick="history.go(-1)">
	</div>
</form>