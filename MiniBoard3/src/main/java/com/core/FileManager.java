package com.core;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import java.util.*;
import java.io.*;

/**
 * ���� ����  
 *
 * ���� ���ε�, ���� �ٿ�ε�, ���� ���� 
 */
public class FileManager {
	private static final int MAX_UPLOAD_SIZE = 30 * 1024 * 1024;
	
	// �Ϲ� ��� ������ 
	private static HashMap<String, String> postData = new HashMap<>();
	
	/**
	 * ���� ���ε� ó�� 
	 * 
	 * @param request
	 * @return ���ε�� ���� URL 
	 */
	public static String upload(HttpServletRequest request) {
		
		StringBuilder sb = new StringBuilder();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			// setSizeMax, setFileSizeMax 
			upload.setSizeMax(MAX_UPLOAD_SIZE);
		
			String uploadPath = request.getServletContext().getRealPath(File.separator + "resources" + File.separator + "upload");
			// ���� ��ΰ� ���� �� ����(src/main/webapp/resources/upload
			String uploadURL = request.getServletContext().getContextPath() + "/resources/upload";
			//ContextPath -> /MiniBoard
			
			
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> params = items.iterator();
			
			boolean isFirstFile = true; //ó�� ó���Ǵ� ���� ����
			while(params.hasNext()) {
				FileItem item = params.next();
				if (item.isFormField()) { // �Ϲ� ��� ������ 
					String key = item.getFieldName();
					String value = item.getString("UTF-8");
					postData.put(key, value);
				} else { // ���� ������ 
					
					/**
					 * 1. ������ ���� ��� -> File �ν��Ͻ��� ����(���� ���ε�� ���ϸ�) (O)
					 * 2. FileItem item . write(File �ν��Ͻ�); -> ������ ���� ��� ���ε� 
					 * 3. ��ȯ�� ���� ���ε� ����
					 * 		1) ���ε�� ���� FULL URL
					 */
					
					String contentType = item.getContentType(); //image/png, image/jpeg, ...
					if(contentType.indexOf("image") == -1) { //�̹��� ������ �ƴ� ��� �ǳʶٱ�
						continue;
					}
					
					
					String fileName = item.getName(); // ���ε�� ��� ���� ���� �� 
					// C:\desktop\....\folder\folder\1.png
					fileName = System.currentTimeMillis() + "_" + fileName.substring(fileName.lastIndexOf(File.separator) + 1);
					
					File file = new File(uploadPath + File.separator + fileName);
					item.write(file);
					
					if(!isFirstFile) {
						sb.append("||");
					}
					
					sb.append(uploadURL + "/" + fileName);
					
					isFirstFile = false;
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}