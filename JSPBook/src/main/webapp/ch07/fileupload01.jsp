<%@ page contentType="text/html; charset=utf-8" %>
<form method="post" action="fileupload01_process.jsp" enctype="multipart/form-data">
	제목1 : <input type="text" name="subject1"><br>
	제목2 : <input type="text" name="subject2"><br>
	업로드 파일1 : <input type="file" name="filename1"><br>
	업로드 파일2 : <input type="file" name="filename2"><br>
	<input type="submit" value="업로드">
</form>