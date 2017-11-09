package com.xlj.forum.struts.interceptor;

import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.aop.MethodBeforeAdvice;

import com.xlj.forum.struts.action.BoardAction;
import com.xlj.forum.struts.action.CategoryAction;
import com.xlj.forum.struts.action.ForumAction;
import com.xlj.forum.struts.action.PersonAction;
import com.xlj.forum.struts.action.ReplyAction;
import com.xlj.forum.struts.action.ThreadAction;
import com.xlj.forum.struts.form.ForumForm;
import com.xlj.forum.struts.util.PersonUtil;


/**
 * 方法前拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] args, Object instance)
			throws Throwable {
		ActionMapping mapping=(ActionMapping)args[0];//mapping参数
		ActionForm form=(ActionForm)args[1];//form参数
		HttpServletRequest request=(HttpServletRequest)args[2];
		HttpServletResponse response=(HttpServletResponse)args[3];
		
		ForumAction forumAction=(ForumAction)instance;
		ForumForm forumForm=(ForumForm)form;
		
		boolean needsCheck=false;//是否需要验证登录
		if(forumAction instanceof PersonAction){//PersonAction不验证
			
		}else if(forumAction instanceof CategoryAction
				|| forumAction instanceof BoardAction
				|| forumAction instanceof ThreadAction
				|| forumAction instanceof ReplyAction){//其余的都要验证
			if("initAdd".equals(forumForm.getAction()) || "add".equals(forumForm.getAction())){
				needsCheck=true;
			}
		}
		
		//如果需要验证，且没有登录，则抛出异常
		if(needsCheck && PersonUtil.getPersonInfo(request, response)==null){
			throw new AccountException("您还没有登录");
		}
	}

}
