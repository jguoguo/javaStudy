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
		message="����û�";
		return SUCCESS;
	}
	public String del() throws Exception{
		message="ɾ���û�";
		return SUCCESS;
	}
	public String update() throws Exception{
		message="�޸��û�";
		return SUCCESS;
	}
	public String list() throws Exception{
		message="��ѯ�û�";
		return SUCCESS;
	}
}
