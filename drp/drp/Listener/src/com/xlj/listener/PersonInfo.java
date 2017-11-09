package com.xlj.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class PersonInfo implements HttpSessionActivationListener,
		HttpSessionBindingListener, Serializable {//因为会被串行化，需要实现Serializable
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Log log=LogFactory.getLog(getClass());
	private String name;

	public void valueBound(HttpSessionBindingEvent arg0) {

	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
