package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;



public class LoginAction implements Action{
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception{
		if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

}
