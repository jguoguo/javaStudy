package com.bjpowernode.struts2;

import java.util.Date;

import com.opensymphony.xwork2.Action;

public class AddUserAction {

	private String userName;
	private Date birthday;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String execute() throws Exception{
		System.out.println("userName"+userName);
		System.out.println("birthday"+birthday);
		return Action.SUCCESS;
	}
}
