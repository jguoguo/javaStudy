package com.bjpowernode.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		UserManager userManager=new UserManager();
		userManager.modify(username);
		return "/modify_success.jsp";
	}

}
