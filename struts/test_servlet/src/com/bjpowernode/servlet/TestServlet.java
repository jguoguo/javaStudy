package com.bjpowernode.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI=req.getRequestURI();
		System.out.println("request:"+requestURI);
		String path=requestURI.substring(requestURI.indexOf("/",1),requestURI.indexOf(".",1));
		System.out.println(path);
		String username=req.getParameter("username");
		UserManager userManager=new UserManager();
		String forword="";
		if("/servlet/addUser".equals(path)){
			userManager.add(username);
			forword="/add_success.jsp";
		}else if("/servlet/delUser".equals(path)){
			userManager.del(username);
			forword="/del_success.jsp";
		}else if("/servlet/modifyUser".equals(path)){
			userManager.modify(username);
			forword="/modify_success.jsp";
		}else if("/servlet/queryUser".equals(path)){
			List userList=userManager.query(username);
			req.setAttribute("userList", userList);
			forword="/query_success.jsp";
		}else{
			throw new RuntimeException("«Î«Û ß∞‹");
		}
		//super.doGet(req, resp);
		req.getRequestDispatcher(forword).forward(req, resp);
		/**
		 * <action-config>
		 * 	<action path="">
		 * </action-config>
		 */
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
		//super.doPost(req, resp);
	}
	
}
