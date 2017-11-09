package com.bjpowernode.usermgr.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjpowernode.usermgr.usermanager.UserManager;
import com.bjpowernode.usermgr.usermanager.UserManagerImpl;
import com.bjpowernode.usermgr.web.forms.LoginActionForm;

public class LoginAction extends Action {

	private UserManager userManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		LoginActionForm laf=(LoginActionForm)form;
		String username=laf.getUsername();
		String password=laf.getPassword();

		userManager.login(username, password);
		return mapping.findForward("success");
	}
	
}
