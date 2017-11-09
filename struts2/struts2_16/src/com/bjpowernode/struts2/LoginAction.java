package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;



public class LoginAction implements Action{
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception{

		UserManager userManager=new UserManager();
		userManager.login(username, password);
		return SUCCESS;
	}
}
