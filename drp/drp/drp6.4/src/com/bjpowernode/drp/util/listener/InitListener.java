package com.bjpowernode.drp.util.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.Constants;

/**
 * 采用ServletContextListener完成初始化
 * @author Administrator
 *
 */
public class InitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("InitListener.init()");
		System.out.println("创建BeanFactory");
		//将抽象工厂放到ServletContext中
		BeanFactory beanFactory=BeanFactory.getInstance();
		sce.getServletContext().setAttribute("beanFactory", beanFactory);
		//加入常量
		sce.getServletContext().setAttribute("add", Constants.ADD);
		sce.getServletContext().setAttribute("del", Constants.DEL);
		sce.getServletContext().setAttribute("modify", Constants.MODIFY);
		sce.getServletContext().setAttribute("showAdd", Constants.SHOW_ADD);
		sce.getServletContext().setAttribute("query", Constants.QUERY);
		sce.getServletContext().setAttribute("audit", Constants.AUDIT);
		sce.getServletContext().setAttribute("detail", Constants.DETAIL);
	}

}
