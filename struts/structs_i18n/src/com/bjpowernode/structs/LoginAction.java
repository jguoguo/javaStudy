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
 * ��¼Action
 * ����ȡ�ñ����ݣ�����ҵ���߼�������ת����Ϣ
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
//			//��¼�ɹ�
//			return mapping.findForward("success");
//		}else{
//			//��¼ʧ��
//			return mapping.findForward("error");
//		}
		UserManager userManager=new UserManager();
		ActionMessages messages=new ActionMessages();
		try{
			userManager.login(username, password);
			//�������ʻ���Ϣ�ı�
			ActionMessage message=new ActionMessage("login.success",username);
			messages.add("login_success_1", message);
			//���ݹ��ʻ���Ϣ
			this.saveMessages(request, messages);
			return mapping.findForward("success");
		}catch(UserNotFoundException e){
			e.printStackTrace();
			//�������ʻ���Ϣ�ı�
			ActionMessage message=new ActionMessage("login.user.not.found",username);
			messages.add("error_1", message);

			//���ݹ��ʻ���Ϣ
			this.saveErrors(request, messages);
			//request.setAttribute("msg", "�û������ҵ�,�û�����=��"+username+"��");
		}catch(PasswordErrorException e){
			e.printStackTrace();
			//�������ʻ���Ϣ�ı�
			ActionMessage message=new ActionMessage("login.password.error",username);
			messages.add("error_2", message);

			//���ݹ��ʻ���Ϣ
			this.saveErrors(request, messages);
			//request.setAttribute("msg", "�������");
		}
		return mapping.findForward("error");
	}

}
