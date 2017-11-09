package com.xlj.gzip;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponseWrapper extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	//自定义的outputStream，执行close()的时候对数据压缩，并输出
	private GZipOutputStream gzipOutputStream;
	//自定义printWriter 将内容输出到GzipOutputStream中
	private PrintWriter writer;
	public GZipResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response=response;
	}
	//覆盖getOutputStream()方法，处理二进制内容
	public ServletOutputStream getOutputStream() throws IOException{
		if(gzipOutputStream==null){
			gzipOutputStream=new GZipOutputStream(response);
		}
		return gzipOutputStream;
	}
	//覆盖getWriter()方法， 处理字符内容
	public PrintWriter getWriter() throws IOException{
		if(writer==null){
			writer=new PrintWriter(new OutputStreamWriter(new GZipOutputStream(response),"UTF-8"));
		}
		return writer;
	}
	//压缩后数据长度会变化 因此将该方法内容置空
	public void setContentLength(int contentLength){
	}
	//执行该方法将数据进行GZIP压缩，并输出到浏览器，代码见gzipOutputStream.close();
	
	public void finishResponse() throws IOException {
		if(gzipOutputStream!=null){
			gzipOutputStream.close();
		}
		if(writer!=null){
			writer.close();
		}
		
	}
}
