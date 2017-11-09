package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;

public class UserAction {

	
	private String userCode;
	private String userName;
	private String message;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String execute() throws Exception{
		UserManager usermgr=new UserManager();
		usermgr.add(userCode, userName);
		return Action.SUCCESS;
	}
}
