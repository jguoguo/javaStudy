package com.bjpowernode.drp.util.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session=request.getSession();
		user=(User)session.getAttribute("user_info");
		
	}
	protected String getCommand(){
		return command;
	}
	protected User getCurrentUser(){
		return user;
	}
	protected BeanFactory getBeanFactory(){
		//��ServletContext��ȡ��beanFactory
		beanFactory=(BeanFactory) this.getServletContext().getAttribute("beanFactory");
		return beanFactory;
	}
}
