package com.bjpowernode.drp.util.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.DefaultBeanFactory;

/**
 * ����ϵͳ��Server�����ǳ�ʼ��
 * @author Administrator
 *
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//����ȱʡ����
		BeanFactory beanFactory=new DefaultBeanFactory();
		//���������õ�ServletContext��
		this.getServletContext().setAttribute("beanFactory", beanFactory);
	}
	
}
