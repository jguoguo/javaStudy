package com.xlj.struts.exception;

import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;


/**
 * 异常捕获
 * @author Administrator
 *
 */

public class ForumExceptionHandler extends ExceptionHandler {

	@Override
	public ActionForward execute(Exception exception, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("exception", exception);
		
		if(exception instanceof AccountException){
			return new ActionForward("login","form/person/login.jsp",false);//转到jsp
		}
		return new ActionForward("exception","form/exception.jsp",false);
	}
	
}
