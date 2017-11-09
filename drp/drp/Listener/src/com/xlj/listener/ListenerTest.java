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
		ServletRequestListener, ServletContextListener {//同时实现多种Listener
	
	Log log=LogFactory.getLog(getClass());//日志记录器
	
	public void contextInitialized(ServletContextEvent sce) {
		//加载servlet上下文时被调用
		ServletContext servletContext=sce.getServletContext();
		//新加载的Servlet上下文
		log.info("即将启动"+servletContext.getContextPath());
		System.out.println("111111111111111");
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		//销毁servlet上下文时被调用
		ServletContext servletContext=sce.getServletContext();
		log.info("即将关闭"+servletContext.getContextPath());
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		//销毁Request时被调用
		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
		long time=System.currentTimeMillis()-(Long)request.getAttribute("dataCreated");
		log.info(request.getRemoteAddr()+"请求处理结束，用时"+time+"毫秒。");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		//创建Request时被调用
		HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
		String uri=request.getRequestURI();//访问的URL路径
		uri=request.getQueryString()==null?uri:(uri+"?"+request.getQueryString());
		request.setAttribute("dataCreated", System.currentTimeMillis());//存储到Session中
		log.info("IP "+request.getRemoteAddr()+" 请求 "+uri);

	}

	public void sessionCreated(HttpSessionEvent se) {
		//创建session时被调用
		HttpSession session=se.getSession();//新创建session
		log.info("新建一个session,ID为:"+session.getId());//记录日志

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//销毁Session前被调用
		HttpSession session=se.getSession();//即将被销毁的session
		log.info("销毁一个session,ID为:"+session.getId());

	}

}
