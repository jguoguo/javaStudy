package com.xlj.struts.exceptionHandler;

import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;


public class AccountExceptionHandler extends ExceptionHandler {

	@Override
	public ActionForward execute(Exception exception, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		if(exception instanceof AccountException){
			return mapping.findForward("login");
		}
		return super.execute(exception, ae, mapping, formInstance, request, response);
	}

}
