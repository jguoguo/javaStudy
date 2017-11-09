package com.xlj.gzip;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GZipFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String acceptEncoding=request.getHeader("Accept-Encoding");//支持的编码方式
		if(acceptEncoding!=null && acceptEncoding.toLowerCase().indexOf("gzip")!=-1){//若支持gzip编码
			//如果客户浏览器支持GZIP格式，则使用GZIP压缩数据
			GZipResponseWrapper gzipRes=new GZipResponseWrapper(response);
			chain.doFilter(request, response);
			
		}else{
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
