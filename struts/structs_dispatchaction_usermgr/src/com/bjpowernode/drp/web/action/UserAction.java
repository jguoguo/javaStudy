package com.bjpowernode.drp.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.bjpowernode.drp.manager.UserManager;
import com.bjpowernode.drp.model.User;
import com.bjpowernode.drp.web.forms.UserActionForm;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UserAction extends DispatchAction {

	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List userList=UserManager.getInstance().findAllUserList();
		request.setAttribute("userlist",userList);
		return mapping.findForward("list_success");
	}
	
	/**
	 * 添加用户
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//调用业务逻辑
		UserActionForm uaf=(UserActionForm)form;
		User user=new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		UserManager.getInstance().addUser(user);
		return mapping.findForward("add_success");
	}
	
	/**
	 * 用户删除
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过了的值
		UserActionForm uaf=(UserActionForm)form;
		String[] userIdList=uaf.getSelectFlag();
		UserManager.getInstance().deleteUsers(userIdList);
		return mapping.findForward("del_success");
	}
	
	/**
	 * 修改用户
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过了的值
		UserActionForm uaf=(UserActionForm)form;
		User user=new User();
		BeanUtils.copyProperties(user, uaf);
		//调用业务逻辑
		UserManager.getInstance().modifyUser(user);
		return mapping.findForward("modify_success");
	}
	
	public ActionForward find(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过了的值
		UserActionForm uaf=(UserActionForm)form;
		String userId=uaf.getUserId();
		User user=UserManager.getInstance().findUserById(userId);;
		request.setAttribute("user", user);
		return mapping.findForward("find_success");
	}
}
