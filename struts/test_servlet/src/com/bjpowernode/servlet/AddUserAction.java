package com.bjpowernode.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		//�����������
		
		//����ҵ���߼�
		UserManager userManager=new UserManager();
		userManager.add(username);
		return "/add_success.jsp";
	}

}
