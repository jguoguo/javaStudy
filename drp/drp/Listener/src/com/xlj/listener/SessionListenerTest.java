package com.xlj.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		//创建Session时被调用
		HttpSession session=se.getSession();//新创建的session
		System.out.println("新创建一个session："+session);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		//销毁Session前被调用
		HttpSession session=se.getSession();//即将被销毁的session
		System.out.println("销毁一个session:"+session);
	}

}
