package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ����beanWrite��ǩ
 * @author Administrator
 *
 */
public class BeanWriteTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//��ͨ��ǩ
		request.setAttribute("hello", "helloWorld");
		//html��ǩ
		request.setAttribute("bj", "<font color='red'>������ӭ��</font>");
		return mapping.findForward("success");
	}
	
}
