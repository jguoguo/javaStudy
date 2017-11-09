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
 * ����ǰ������
 * @author Administrator
 *
 */
public class LoginInterceptor implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] args, Object instance)
			throws Throwable {
		ActionMapping mapping=(ActionMapping)args[0];//mapping����
		ActionForm form=(ActionForm)args[1];//form����
		HttpServletRequest request=(HttpServletRequest)args[2];
		HttpServletResponse response=(HttpServletResponse)args[3];
		
		ForumAction forumAction=(ForumAction)instance;
		ForumForm forumForm=(ForumForm)form;
		
		boolean needsCheck=false;//�Ƿ���Ҫ��֤��¼
		if(forumAction instanceof PersonAction){//PersonAction����֤
			
		}else if(forumAction instanceof CategoryAction
				|| forumAction instanceof BoardAction
				|| forumAction instanceof ThreadAction
				|| forumAction instanceof ReplyAction){//����Ķ�Ҫ��֤
			if("initAdd".equals(forumForm.getAction()) || "add".equals(forumForm.getAction())){
				needsCheck=true;
			}
		}
		
		//�����Ҫ��֤����û�е�¼�����׳��쳣
		if(needsCheck && PersonUtil.getPersonInfo(request, response)==null){
			throw new AccountException("����û�е�¼");
		}
	}

}
