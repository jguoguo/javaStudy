package com.bjpowernode.structs;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ChangeLanguageAction extends Action {

	/**
	 * 完成语言的手动切换
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		Locale locale=Locale.getDefault();
		String lang=request.getParameter("lang");
		if("zh".equals(lang)){
			locale=new Locale("zh","CN");
		}else if("en".equals(lang)){
			locale=new Locale("en","US");
		}
		//将local设置到session中
		request.getSession().setAttribute(Globals.LOCALE_KEY, locale);
		return mapping.findForward("index");
	}

}
