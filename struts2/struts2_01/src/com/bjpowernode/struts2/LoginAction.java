package com.bjpowernode.struts2;

public class LoginAction {
	
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
		if("admin".equals(username) && "admin".equals(password)){
			return "success";
		}else{
			return "error";
		}
	}
}
