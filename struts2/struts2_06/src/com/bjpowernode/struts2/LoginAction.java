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
			//将登陆信息设置到Session中
			ActionContext.getContext().getSession().put("user", username);
			//采用如下方式访问request对象
			//ActionContext.getContext().put("user", username);
			//采用如下方式访问application对象
			//ActionContext.getContext().getApplication().put("user", username);
			//通过request.getParameter()取得数据
			//String username=(String)ActionContext.getContext().getParameters().get("user");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
