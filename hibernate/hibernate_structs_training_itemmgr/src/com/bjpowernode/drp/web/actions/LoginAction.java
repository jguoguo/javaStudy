package com.bjpowernode.drp.web.actions;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjpowernode.drp.web.forms.LoginActionForm;
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
		
		
		if("admin".equals(username) && "admin".equals(password)){
			String remoteAddr=request.getRemoteAddr();//获取连接IP地址
			String[] allowIps=request.getSession().getServletContext().getInitParameter("allow_ip").split(",");
			Arrays.sort(allowIps);//排序
			if(Arrays.binarySearch(allowIps, remoteAddr)<0){
				return mapping.findForward("index");
			}
			
			//设置session
			request.getSession().setAttribute("user", username);
			return mapping.findForward("success");
		}else{
			//登录失败
			return mapping.findForward("index");
		}
		
		
//		UserManager userManager=new UserManager();
//		try{
//			userManager.login(username, password);
//			request.getSession().setAttribute("username", username);
//			return mapping.findForward("success");
//		}catch(UserNotFoundException e){
//			e.printStackTrace();
//			request.setAttribute("msg", "用户不能找到");
//		}catch(PasswordErrorException e){
//			e.printStackTrace();
//			request.setAttribute("msg", "密码错误");
//		}
//		return mapping.findForward("error");
	}

}
