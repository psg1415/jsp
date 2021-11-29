<%@ page contentType="text/html; charset=utf-8" %>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/sy.css">
<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css">

<div class="add">
	<h1 style="text-align: center;">상품 등록</h1>

 <form name="newGoods"  >
 
	상품 목록 <input type="text" id="goodsId" name="goodsId" > <br>
	
	상품 이름 <input type="text" id="goodsNm" name="name" > <br>
	
	가격 <input type="text" id="unitPrice" name="unitPrice" ><br>

	상세 내용  <textarea name="description" cols="50" rows="2" ></textarea><br>
	 
	상품 이미지 <input type="file" name="goodsImage" ><br>
	
	<input type="button"  value="등록" onclick="location='../main/index.jsp'">

			
	</form>
	
</div>
