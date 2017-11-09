package com.xlj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListenerTest implements HttpSessionListener,
		ServletRequestListener, ServletContextListener {//ͬʱʵ�ֶ���Listener
	
	Log log=LogFactory.getLog(getClass());//��־��¼��
	
	public void contextInitialized(ServletContextEvent sce) {
		//����servlet������ʱ������
		ServletContext servletContext=sce.getServletContext();
		//�¼��ص�Servlet������
		log.info("��������"+servletContext.getContextPath());
		System.out.println("111111111111111");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		//����servlet������ʱ������
		ServletContext servletContext=sce.getServletContext();
		log.info("�����ر�"+servletContext.getContextPath());
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		//����Requestʱ������
		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
		long time=System.currentTimeMillis()-(Long)request.getAttribute("dataCreated");
		log.info(request.getRemoteAddr()+"�������������ʱ"+time+"���롣");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		//����Requestʱ������
		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
		String uri=request.getRequestURI();//���ʵ�URL·��
		uri=request.getQueryString()==null?uri:(uri+"?"+request.getQueryString());
		request.setAttribute("dataCreated", System.currentTimeMillis());//�洢��Session��
		log.info("IP "+request.getRemoteAddr()+" ���� "+uri);

	}

	public void sessionCreated(HttpSessionEvent se) {
		//����sessionʱ������
		HttpSession session=se.getSession();//�´���session
		log.info("�½�һ��session,IDΪ:"+session.getId());//��¼��־

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//����Sessionǰ������
		HttpSession session=se.getSession();//���������ٵ�session
		log.info("����һ��session,IDΪ:"+session.getId());

	}

}
