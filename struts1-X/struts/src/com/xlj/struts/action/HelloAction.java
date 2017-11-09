/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.xlj.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.xlj.struts.form.HelloForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-07-2015
 * 
 * XDoclet definition:
 * @struts.action path="/hello" name="helloForm" input="/form/hello.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/form/helloSuccess.jsp"
 */
public class HelloAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HelloForm helloForm = (HelloForm) form;// TODO Auto-generated method stub
		if(helloForm.getName()==null || helloForm.getName().trim().length()==0){
			//�򷵻�����ҳ��Ҳ����/form/hello.jsp,������struts-config.xml��
			return mapping.getInputForward();
		}
		//ת��successҳ�棬Ҳ����/form/helloSuccess.jsp��
		return mapping.findForward("success");
	}
}