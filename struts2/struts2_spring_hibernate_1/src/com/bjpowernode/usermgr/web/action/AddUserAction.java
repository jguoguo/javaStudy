package com.bjpowernode.usermgr.web.action;

import com.bjpowernode.usermgr.domain.User;
import com.bjpowernode.usermgr.service.UserService;
import com.opensymphony.xwork2.Action;

public class AddUserAction implements Action {

	private User user;
	private UserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		
		userService.add(user);
		return SUCCESS;
	}

}
