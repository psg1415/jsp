<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.model.dao.Board2DAO" %>
<%@ page import="com.model.dto.Board" %>
<%@ page import="java.util.ArrayList" %>
<%
Board2DAO dao = new Board2DAO();
ArrayList<Board> list = dao.getList(1);
%>
<h1>블로그!</h1>
<div id='blog_content'>
<%
	for(Board board : list){
	%>
	<div class='post_content' style="border: 1px solid black; padding: 10px; margin: 10px">
		<h2><%=board.getSubject() %></h2>
		<div class='content'>
			<%=board.getContent() %>
		</div>
	</div>
<%
	}
%>
</div>
<button type="button">다음 블로그 게시글 보기...
jquery
$.ajax({
	url : "요청 URL",
	type : "요청 메서드 (GET, POST)",
	data : 요청 URL로 전송할 데이터(json, 쿼리스트링(k=1&t=2)),
	dataType : "반환할 데이터 타입 html|text|json",
	success : function (res) { //요청이 성공했을때 반환 출력값
		$("#blog_conteng").append(res);
	},
	error : function(err){ //요청이 실패 했을때 반환되는 에러 객체
	}
});

</button>