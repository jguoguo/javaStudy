package com.xlj.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.bean.Person;
import com.xlj.struts.form.UseBeanForm;

public class UseBeanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UseBeanForm useBeanForm=(UseBeanForm)form;//UseBeanForm对象
		if("add".equals(useBeanForm.getAction())){
			Person person=useBeanForm.getPerson();
			response.getWriter().println("person.account"+person.getAccount());
			response.getWriter().println("person.name"+person.getName());
			return null;
		}
		return mapping.getInputForward();//否则返回输入页面
	}

}
