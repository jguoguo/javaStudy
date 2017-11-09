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

		//�����ĵ�����A4ֽ��С
		Document document=new Document(PageSize.A4);
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		try{
			//���ΪE:\itext.pdf�ļ�
			PdfWriter writer=PdfWriter.getInstance(document, stream);
			//���ĵ�
			document.open();
			//pdf�ļ���д������
			document.add(new Paragraph("Hello World,Hello iText"));
			//�ر��ļ�
			document.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		//������Ӧ�ĵ�����Ϊpdf
		response.setContentType("application/pdf");
		//������Ӧ���ݴ�С
		response.setContentLength(stream.size());
		//��ȡ��Ӧ������
		ServletOutputStream out=response.getOutputStream();
		//��pdf������д����Ӧ��������
		stream.writeTo(out);
		out.flush();
		out.close();
	}

}
