<%@ page contentType="text/html; charset=utf-8" %>
<h3>파일 업로드</h3>
<form method="post" action="upload" enctype="multipart/form-data" target='ifrmHidden'>
	<input type="file" name="file">
	<input type="file" name="file2">
	<input type="file" name="file3">
	<input type="submit" value="업로드">
</form>