package com.bjpowernode.struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MustLoginAction implements Action {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("user")==null){
			return LOGIN;
		}
		return SUCCESS;
	}

}
