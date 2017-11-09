package com.bjpowernode.drp.util.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.Constants;

/**
 * ����ServletContextListener��ɳ�ʼ��
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
		System.out.println("����BeanFactory");
		//�����󹤳��ŵ�ServletContext��
		BeanFactory beanFactory=BeanFactory.getInstance();
		sce.getServletContext().setAttribute("beanFactory", beanFactory);
		//���볣��
		sce.getServletContext().setAttribute("add", Constants.ADD);
		sce.getServletContext().setAttribute("del", Constants.DEL);
		sce.getServletContext().setAttribute("modify", Constants.MODIFY);
		sce.getServletContext().setAttribute("showAdd", Constants.SHOW_ADD);
		sce.getServletContext().setAttribute("query", Constants.QUERY);
		sce.getServletContext().setAttribute("audit", Constants.AUDIT);
		sce.getServletContext().setAttribute("detail", Constants.DETAIL);
	}

}
