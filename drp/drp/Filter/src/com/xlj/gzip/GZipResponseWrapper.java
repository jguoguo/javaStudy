package com.xlj.gzip;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponseWrapper extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	//�Զ����outputStream��ִ��close()��ʱ�������ѹ���������
	private GZipOutputStream gzipOutputStream;
	//�Զ���printWriter �����������GzipOutputStream��
	private PrintWriter writer;
	public GZipResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response=response;
	}
	//����getOutputStream()�������������������
	public ServletOutputStream getOutputStream() throws IOException{
		if(gzipOutputStream==null){
			gzipOutputStream=new GZipOutputStream(response);
		}
		return gzipOutputStream;
	}
	//����getWriter()������ �����ַ�����
	public PrintWriter getWriter() throws IOException{
		if(writer==null){
			writer=new PrintWriter(new OutputStreamWriter(new GZipOutputStream(response),"UTF-8"));
		}
		return writer;
	}
	//ѹ�������ݳ��Ȼ�仯 ��˽��÷��������ÿ�
	public void setContentLength(int contentLength){
	}
	//ִ�и÷��������ݽ���GZIPѹ�����������������������gzipOutputStream.close();
	
	public void finishResponse() throws IOException {
		if(gzipOutputStream!=null){
			gzipOutputStream.close();
		}
		if(writer!=null){
			writer.close();
		}
		
	}
}
