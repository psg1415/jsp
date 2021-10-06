<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%
String fileUploadPath = getServletContext().getRealPath("//upload");
ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

List<FileItem> items = upload.parseRequest(request);

Iterator<FileItem> params = items.iterator();
while(params.hasNext()) {
	FileItem fileitem = params.next();
	if (!fileitem.isFormField()) { // 일반 데이터가 아닌 경우 -> 파일 데이터
		String filename = fileitem.getName(); // 경로 포함 파일명
		//D:\폴터1\폴더2\파일명
		//indexOf(문자열) -> 찾는 문자열의 위치, -1 -> 앞에서부터 찾는다
		//문자열의 위치 번호
		//lastIndexOf(문자열) -> 찾는 문자열의 위치(뒤에서 부터)
		//File static separator - OS 상관없이 파일, 디렉토리 구분자
			//윈도우즈(\), 리눅스, 맥(/)
		//filename = filename.substring(filename.indexOf("\\") +1);
		filename = System.currentTimeMillis() + "_" + filename.substring(filename.lastIndexOf(File.separator) +1);
		
		File file = new File(fileUploadPath + File.separator + filename);
		fileitem.write(file);
	}
}
%>