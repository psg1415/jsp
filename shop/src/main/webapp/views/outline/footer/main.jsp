<%@ page contentType="text/html; charset=utf-8" %>
<%
	String environment = (String)request.getAttribute("environment");
%>

		</main>
		<footer>
      <div class="footer">
        <span class="category"><a href="${rootURL}/category">카테고리</a></span>
        <span class="mypage"><a href="${rootURL}/member/mypage">마이페이지</a></span>
        <span class="shoppingbag"><a href="${rootURL}">장바구니</a></span>
      </div>
    </footer>
    <iframe <%=environment.equals("production")?" class='dn'":""%>name="ifrmHidden" width="100%" height="0" frameborder="0"></iframe>
 	</body>
</html>