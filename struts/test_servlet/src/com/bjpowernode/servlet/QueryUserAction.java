package com.bjpowernode.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		UserManager userManager=new UserManager();
		List userList=userManager.query(username);
		req.setAttribute("userList", userList);
		return "/query_success.jsp";
	}

}
