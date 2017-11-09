package com.bjpowernode.drp.basedata.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;
import com.bjpowernode.drp.util.ApplicationException;

public class FileUploadServlet extends HttpServlet {

	private ItemManager itemManager;
	private File uploadPath;
	
	
	private File tempPath;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//form�ύ����multipart/form-data,�޷�����req.getParameter()ȡ������
		//String itemNo = req.getParameter("itemNo");
		//System.out.println("itemNo======" + itemNo);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(4096);
		// the location for saving data that is larger than getSizeThreshold()
		factory.setRepository(tempPath);//��ʱ����Ŀ¼

		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum size before a FileUploadException will be thrown
		upload.setSizeMax(1000000 * 20);//20M
		try {
			List fileItems = upload.parseRequest(req);
			String itemNo = "";
			for (Iterator iter = fileItems.iterator(); iter.hasNext();) {
				FileItem item = (FileItem) iter.next();
				
				//����ͨ�ı�������
				if(item.isFormField()) {
					if ("itemNo".equals(item.getFieldName())) {
						itemNo = item.getString();
					}
				}
				//�Ƿ�Ϊinput="type"������
				if (!item.isFormField()) {
					String fileName = item.getName();
					long size = item.getSize();
					if ((fileName == null || fileName.equals("")) && size == 0) {
						continue;
					}
					//��ȡ�ַ��� �磺C:\WINDOWS\Debug\PASSWD.LOG
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());

					item.write(new File(uploadPath, fileName));
					itemManager.uploadFile(itemNo, fileName);
				}
			}
			res.sendRedirect(req.getContextPath() + "/servlet/item/SearchItemServlet");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("�ϴ�ͼƬʧ��");
		}
	}

	public void init() throws ServletException {
		uploadPath = new File(getServletContext().getRealPath("upload"));
		System.out.println("uploadPath=====" + uploadPath);
		//���Ŀ¼������
		if (!uploadPath.exists()) {
			//����Ŀ¼
			uploadPath.mkdir();
		}
		
		//��ʱĿ¼�����ڽ���
		tempPath = new File(getServletContext().getRealPath("temp"));
		if (!tempPath.exists()) {
			tempPath.mkdir();
		}
		itemManager=new ItemManagerImpl();
	}
}
