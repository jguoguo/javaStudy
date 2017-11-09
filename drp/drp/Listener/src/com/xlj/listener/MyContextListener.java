package com.xlj.listener;



import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xlj.util.ApplicationConstants;


/**
 * 监听服务器的启动与关闭
 * @author Administrator
 *
 */
public class MyContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		//服务器启动时被调用
		ApplicationConstants.START_DATE=null;//记录启动时间
		ApplicationConstants.MAX_ONLINE_COUNT_DATE=null;//清空结果，也可以保存
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//服务器关闭时被调用
		ApplicationConstants.START_DATE=new Date();//清空结果，也可以保存
		
	}

}
