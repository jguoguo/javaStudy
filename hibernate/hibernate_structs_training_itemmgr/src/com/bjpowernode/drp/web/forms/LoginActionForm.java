package com.bjpowernode.drp.web.forms;

import org.apache.struts.action.ActionForm;

/**
 * ��½ActionForm ������ռ�����
 * �������Ա����ActionForm��ż��get��set������һ��
 * @author Administrator
 *
 */
public class LoginActionForm extends ActionForm {
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
