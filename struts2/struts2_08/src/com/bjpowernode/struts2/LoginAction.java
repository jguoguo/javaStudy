package com.bjpowernode.struts2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

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
			
			ServletActionContext.getRequest().getSession().setAttribute("user",username);
			
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

}
