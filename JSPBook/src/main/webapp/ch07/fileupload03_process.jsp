<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	out.println("<br>----------------------<br>");
	out.println("name = " + name + "<br>");
	out.println("subject = " + subject + "<br>");

	String uploadPath = getServletContext().getRealPath(File.separator + "upload");
	
	DiskFileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	//5메가
	upload.setSizeMax(5 * 1024 * 1024); //최대 5메가 업로드 가능

	List<FileItem> items = upload.parseRequest(request);
	Iterator<FileItem> params = items.iterator();
	while(params.hasNext()){
		FileItem fileitem = params.next();
		if(fileitem.isFormField()){ //일반 양식 데이터
			String name = fileitem.getFieldName();
			String value = fileitem.getString("UTF-8");
			out.println("name = " + name + ", value = " + value);
		}else{ //파일 데이터
			String filename = fileitem.getName(); //경로 포함 파일명
			filename = System.currentTimeMillis() + "_" + filename.substring(filename.lastIndexOf(File.separator) +1);
			
			String contentType = fileitem.getContentType();
			if(contentType.indexOf("image") != -1){
				out.println("이미지 파일!<br>");
			}else{
				out.println("이미지 파일 아님!<br>");
			}
			
			out.println("파일 형식(MIME) : " + contentType + "<br>");
			File file = new File(uploadPath + File.separator + filename);
			//fileitem.write(file);
			
		}
	}
	
	
%>