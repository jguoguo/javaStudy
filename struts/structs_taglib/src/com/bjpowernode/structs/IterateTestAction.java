package com.bjpowernode.structs;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class IterateTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		Group group=new Group();
		group.setName("动力节点");
		List userList = new ArrayList();
		for(int i=0;i<10;i++){
			User user=new User();
			user.setName("张三_"+i);
			user.setAge(22);
			user.setGroup(group);
			userList.add(user);
		}
		request.setAttribute("user_list", userList);
		return mapping.findForward("success");
	}

}
