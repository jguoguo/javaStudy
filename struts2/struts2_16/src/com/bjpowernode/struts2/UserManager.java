package com.bjpowernode.struts2;

public class UserManager {
	
	public void login(String username, String password) {
		if (!("admin".equals(username) && "admin".equals(password))) {
			throw new ApplicationException("�û��������벻��ȷ");
		}

	}
	
}
