package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 测试beanWrite标签
 * @author Administrator
 *
 */
public class BeanWriteTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//普通标签
		request.setAttribute("hello", "helloWorld");
		//html标签
		request.setAttribute("bj", "<font color='red'>北京欢迎你</font>");
		return mapping.findForward("success");
	}
	
}
