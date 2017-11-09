package com.bjpowernode.struts2;

public class UserManager {
	
	public void login(String username, String password) {
		if (!"admin".equals(username)) {
			throw new UserNotFoundException();
		}
		if (!"admin".equals(password)) {
			throw new PasswordErrorException();
		}
	}
	
}
