<%@ page contentType="text/html; charset=utf-8" %>


<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/sy.css">
<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css">


<div class="account">
  <form name="acount" >
  
	<h1 style="text-align: center;">회원 정보 수정</h1>
				
	회원 이름 수정  <input type="text"  name="nameChange" > <br>
	아이디 수정  <input type="text"  name="idChange" > <br>
	비밀번호 수정  <input type="text"  name="passwordChange" > <br>
	전화 번호 수정
	<select name="phone1">
	
	  <option>010</option>
	
	  <option>02</option>
	
	  <option>031</option>
	
	  <option>051</option>
	  
	</select>
	 - <input type="text" name="phone2" size="5">
	 - <input type="text" name="phone2" size="5">   <br>
	
<input type="button" class="button" value="등록" onclick="location='../member/mypage.jsp'">


</form>
</div>
