package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;



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
		if("admin".equals(username) && "admin".equals(password)){
			//����½��Ϣ���õ�Session��
			ActionContext.getContext().getSession().put("user", username);
			//�������·�ʽ����request����
			//ActionContext.getContext().put("user", username);
			//�������·�ʽ����application����
			//ActionContext.getContext().getApplication().put("user", username);
			//ͨ��request.getParameter()ȡ������
			//String username=(String)ActionContext.getContext().getParameters().get("user");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
