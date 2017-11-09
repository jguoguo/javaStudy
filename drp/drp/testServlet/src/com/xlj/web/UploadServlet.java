package com.xlj.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("请以POST方式上传文件");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file1=null;
		File file2=null;
		String description1=null,description2=null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("  <BODY>");
		
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>上传文件</legend><br/>");
		
		out.println("		<div class='line'>");
		out.println("			<div align='left' class='leftDiv'>上传日志：</div>");
		out.println("			<div align='left' class='rightDiv'>");
		DiskFileUpload diskFieldUpload=new DiskFileUpload();
		try{
			List<FileItem> list=diskFieldUpload.parseRequest(request);
			out.println("遍历所有的 FileItem....<br/>");
			for(FileItem fileItem :list){//遍历所有的FileItem
				if(fileItem.isFormField()){//如果是文本域
					if("description1".equals(fileItem.getFieldName())){//如果是该参数
						out.println("遍历到description1...<br/>");
						description1=new String(fileItem.getString().getBytes(),"UTF-8");
					}
					if("description2".equals(fileItem.getFieldName())){//如果是该参数
						out.println("遍历到description2...<br/>");
						description2=new String(fileItem.getString().getBytes(),"UTF-8");
					}
				}else{//否则为文件域
					if("file1".equals(fileItem.getFieldName())){//如果为file1文件域
						File remoteFile=new File(new String(fileItem.getName().getBytes(),"UTF-8"));
						out.println("遍历到file1...<br/>");
						out.println("客户端文件位置："+remoteFile.getAbsolutePath()+"<br/>");
					}
				}
			}
		}
	}

}
