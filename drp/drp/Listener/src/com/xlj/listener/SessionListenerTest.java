package com.xlj.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		//����Sessionʱ������
		HttpSession session=se.getSession();//�´�����session
		System.out.println("�´���һ��session��"+session);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//����Sessionǰ������
		HttpSession session=se.getSession();//���������ٵ�session
		System.out.println("����һ��session:"+session);
	}

}
