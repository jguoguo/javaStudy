package com.bjpowernode.drp.util.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.sysmgr.domain.User;

public class PasswordValidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GB18030");
		String oldPassword =request.getParameter("oldPassword");
		User user=(User)request.getSession().getAttribute("user_info");
		if(!oldPassword.equals(user.getPassword())){
			response.getWriter().println("输入密码与原密码不符");
		}
	}

}
