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
	 * ����û�
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
		//����ҵ���߼�
		UserActionForm uaf=(UserActionForm)form;
		User user=new User();
		BeanUtils.copyProperties(user, uaf);
		user.setCreateDate(new Date());
		UserManager.getInstance().addUser(user);
		return mapping.findForward("add_success");
	}
	
	/**
	 * �û�ɾ��
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
		//��ȡ��ҳ������ύ���˵�ֵ
		UserActionForm uaf=(UserActionForm)form;
		String[] userIdList=uaf.getSelectFlag();
		UserManager.getInstance().deleteUsers(userIdList);
		return mapping.findForward("del_success");
	}
	
	/**
	 * �޸��û�
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
		//��ȡ��ҳ������ύ���˵�ֵ
		UserActionForm uaf=(UserActionForm)form;
		User user=new User();
		BeanUtils.copyProperties(user, uaf);
		//����ҵ���߼�
		UserManager.getInstance().modifyUser(user);
		return mapping.findForward("modify_success");
	}
	
	public ActionForward find(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��ȡ��ҳ������ύ���˵�ֵ
		UserActionForm uaf=(UserActionForm)form;
		String userId=uaf.getUserId();
		User user=UserManager.getInstance().findUserById(userId);;
		request.setAttribute("user", user);
		return mapping.findForward("find_success");
	}
}
