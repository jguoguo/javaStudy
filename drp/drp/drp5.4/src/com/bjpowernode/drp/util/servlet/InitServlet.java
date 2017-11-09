package com.bjpowernode.drp.util.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.Constants;

/**
 * ����ϵͳ��Server�����ǳ�ʼ��
 * @author Administrator
 *
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//����ȱʡ����
		//BeanFactory beanFactory=new DefaultBeanFactory();
		//���������õ�ServletContext��
		//this.getServletContext().setAttribute("beanFactory", beanFactory);
		
		System.out.println("����BeanFactory");
		//�����󹤳��ŵ�ServletContext��
		BeanFactory beanFactory=BeanFactory.getInstance();
		this.getServletContext().setAttribute("beanFactory", beanFactory);
		//���볣��
		getServletContext().setAttribute("add", Constants.ADD);
		getServletContext().setAttribute("del", Constants.DEL);
		getServletContext().setAttribute("modify", Constants.MODIFY);
		getServletContext().setAttribute("showAdd", Constants.SHOW_ADD);
	}
	
}
