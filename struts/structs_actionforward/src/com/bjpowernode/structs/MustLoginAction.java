package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MustLoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("username")==null){
			
			//自动转向
			ActionForward af= mapping.findForward("login");
			//struts-config.xml文件不能在运行时修改
			//af.setRedirect(false);
			return af;
			
			//手动转向,尽量不要自己转
			//response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		return mapping.findForward("success");
	}
	
}
