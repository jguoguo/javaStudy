package com.xlj.itext;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//创建文档对象，A4纸大小
		Document document=new Document(PageSize.A4);
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		try{
			//输出为E:\itext.pdf文件
			PdfWriter writer=PdfWriter.getInstance(document, stream);
			//打开文档
			document.open();
			//pdf文件中写入文字
			document.add(new Paragraph("Hello World,Hello iText"));
			//关闭文件
			document.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//设置响应文档类型为pdf
		response.setContentType("application/pdf");
		//设置响应数据大小
		response.setContentLength(stream.size());
		//获取响应数据流
		ServletOutputStream out=response.getOutputStream();
		//将pdf数据流写入响应数据流中
		stream.writeTo(out);
		out.flush();
		out.close();
	}

}
