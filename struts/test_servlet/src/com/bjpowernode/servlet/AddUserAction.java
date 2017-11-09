package com.bjpowernode.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		//其他添加条件
		
		//调用业务逻辑
		UserManager userManager=new UserManager();
		userManager.add(username);
		return "/add_success.jsp";
	}

}
