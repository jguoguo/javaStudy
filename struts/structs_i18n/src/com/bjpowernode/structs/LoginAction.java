package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
/**
 * 登录Action
 * 负责取得表单数据，调用业务逻辑，返回转向信息
 * @author Administrator
 *
 */
public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		LoginActionForm laf=(LoginActionForm)form;
		String username=laf.getUsername();
		String password=laf.getPassword();
//		if("admin".equals(username) && "admin".equals(password)){
//			//登录成功
//			return mapping.findForward("success");
//		}else{
//			//登录失败
//			return mapping.findForward("error");
//		}
		UserManager userManager=new UserManager();
		ActionMessages messages=new ActionMessages();
		try{
			userManager.login(username, password);
			//创建国际化消息文本
			ActionMessage message=new ActionMessage("login.success",username);
			messages.add("login_success_1", message);
			//传递国际化消息
			this.saveMessages(request, messages);
			return mapping.findForward("success");
		}catch(UserNotFoundException e){
			e.printStackTrace();
			//创建国际化消息文本
			ActionMessage message=new ActionMessage("login.user.not.found",username);
			messages.add("error_1", message);

			//传递国际化消息
			this.saveErrors(request, messages);
			//request.setAttribute("msg", "用户不能找到,用户名称=【"+username+"】");
		}catch(PasswordErrorException e){
			e.printStackTrace();
			//创建国际化消息文本
			ActionMessage message=new ActionMessage("login.password.error",username);
			messages.add("error_2", message);

			//传递国际化消息
			this.saveErrors(request, messages);
			//request.setAttribute("msg", "密码错误");
		}
		return mapping.findForward("error");
	}

}
