package com.xlj.hibernate.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ����Filterͳһ�����ַ���
 * @author Administrator
 *
 */
public class CharsetEncodingFilter implements Filter {
	private String encoding;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//�����ַ���
		request.setCharacterEncoding(this.encoding);
		//����ִ��
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding=filterConfig.getInitParameter("encoding");
		
	}

}
