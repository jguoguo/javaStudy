package com.bjpowernode.usermgr.web.forms;

import org.apache.struts.action.ActionForm;

public class LoginActionForm extends ActionForm {
	//名字必须和表单上的名字相同
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
	
}
