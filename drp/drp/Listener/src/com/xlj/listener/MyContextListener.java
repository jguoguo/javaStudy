package com.xlj.listener;



import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xlj.util.ApplicationConstants;


/**
 * ������������������ر�
 * @author Administrator
 *
 */
public class MyContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		//����������ʱ������
		ApplicationConstants.START_DATE=null;//��¼����ʱ��
		ApplicationConstants.MAX_ONLINE_COUNT_DATE=null;//��ս����Ҳ���Ա���
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//�������ر�ʱ������
		ApplicationConstants.START_DATE=new Date();//��ս����Ҳ���Ա���
		
	}

}
