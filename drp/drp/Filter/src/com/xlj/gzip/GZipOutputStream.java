package com.xlj.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class GZipOutputStream extends ServletOutputStream {

	//原response
	private HttpServletResponse response;
	//JDK自带的GZIP压缩数据的类
	private GZIPOutputStream gzipOutputStream;
	
	//将压缩后的数据存放到ByteArrayOutputStream对象中
	private ByteArrayOutputStream byteArrayOutputStream;
	
	public GZipOutputStream(HttpServletResponse response) throws IOException{
		this.response=response;
		byteArrayOutputStream=new ByteArrayOutputStream();
		gzipOutputStream=new GZIPOutputStream(byteArrayOutputStream);
	}
	//输出到JDK的GZIP输出类中
	@Override
	public void write(int b) throws IOException {
		gzipOutputStream.write(b);
	}
	//执行压缩，并将数据输出到浏览器
	public void close() throws IOException{
		//执行压缩，一定要调用该方法
		gzipOutputStream.finish();
		//将压缩后的数据输出到客户端
		byte[] content=byteArrayOutputStream.toByteArray();
		//设置压缩方式为GZIP，客户端浏览器会自动将数据解压
		response.addHeader("Content-Encoding", "gzip");
		response.addHeader("Content-Length", Integer.toString(content.length));
		//输出到浏览器
		ServletOutputStream out=response.getOutputStream();
		out.write(content);
		out.close();
	}
	public void flush() throws IOException{
		gzipOutputStream.flush();
	}
	public void write(byte[] b,int off,int len) throws IOException{
		gzipOutputStream.write(b, off, len);
	}
	public void wirte(byte[] b) throws IOException{
		gzipOutputStream.write(b);
	}
}
