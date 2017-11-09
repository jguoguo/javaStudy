package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;



public class LoginAction implements Action,ModelDriven<User>{
	
	User umgr=new User();

	public String execute() throws Exception{
		if("admin".equals(umgr.getUsername()) && "admin".equals(umgr.getPassword())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
