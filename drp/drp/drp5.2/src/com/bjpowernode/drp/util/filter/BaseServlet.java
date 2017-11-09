package com.bjpowernode.drp.util.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.sysmgr.domain.User;
import com.bjpowernode.drp.util.BeanFactory;

public class BaseServlet extends HttpServlet {
	private String command;
	private User user;
	private BeanFactory beanFactory;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		command=request.getParameter("command");
		user=(User)request.getAttribute("user_info");
		
	}
	protected String getCommand(){
		return command;
	}
	protected User getCurrentUser(){
		return user;
	}
	protected BeanFactory getBeanFactory(){
		//从ServletContext中取得beanFactory
		this.getServletContext().getAttribute("beanFactory");
		return beanFactory;
	}
}
