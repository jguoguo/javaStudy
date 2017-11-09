package com.bjpowernode.drp.util.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.Constants;

/**
 * 负责系统在Server启动是初始化
 * @author Administrator
 *
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//创建缺省工厂
		//BeanFactory beanFactory=new DefaultBeanFactory();
		//将工厂设置到ServletContext中
		//this.getServletContext().setAttribute("beanFactory", beanFactory);
		
		System.out.println("创建BeanFactory");
		//将抽象工厂放到ServletContext中
		BeanFactory beanFactory=BeanFactory.getInstance();
		this.getServletContext().setAttribute("beanFactory", beanFactory);
		//加入常量
		getServletContext().setAttribute("add", Constants.ADD);
		getServletContext().setAttribute("del", Constants.DEL);
		getServletContext().setAttribute("modify", Constants.MODIFY);
		getServletContext().setAttribute("showAdd", Constants.SHOW_ADD);
	}
	
}
