package com.bjpowernode.drp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 采用Filter统一处理字符集
 * @author Administrator
 *
 */
public class CharsetEncodingFilter implements Filter {
	
	private String encoding = "GB18030";
	
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		//设置字符集
		servletRequest.setCharacterEncoding(encoding);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
}
