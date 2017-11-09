package com.bjpowernode.drp.util.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestHttpSessionAtributeListener implements
		HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("TestHttpSessionAtributeListenre---->attributeAdded()");
		if("user_info".equals(se.getName())){
			Integer count=(Integer)se.getSession().getServletContext().getAttribute("count");
			if(count==null){
				count=1;
			}else{
				count++;
			}
			se.getSession().getServletContext().setAttribute("count", count);
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("TestHttpSessionAtributeListenre---->attributeRemoved()");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("TestHttpSessionAtributeListenre---->attributeReplaced()");
	}

}
