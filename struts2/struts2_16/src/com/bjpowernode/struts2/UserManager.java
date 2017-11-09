package com.bjpowernode.struts2;

public class UserManager {
	
	public void login(String username, String password) {
		if (!("admin".equals(username) && "admin".equals(password))) {
			throw new ApplicationException("用户名或密码不正确");
		}

	}
	
}
