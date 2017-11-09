package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String add() throws Exception{
		message="添加用户";
		return SUCCESS;
	}
	public String del() throws Exception{
		message="删除用户";
		return SUCCESS;
	}
	public String update() throws Exception{
		message="修改用户";
		return SUCCESS;
	}
	public String list() throws Exception{
		message="查询用户";
		return SUCCESS;
	}
}
