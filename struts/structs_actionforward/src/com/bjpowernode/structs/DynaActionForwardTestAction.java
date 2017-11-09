package com.bjpowernode.structs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 动态的ActionForward
 * @author Administrator
 *
 */
public class DynaActionForwardTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		int page=Integer.parseInt(request.getParameter("page"));
/*		ActionForward af=null;
		if(page==1){
			af= mapping.findForward("page1");
		}else if(page==2){
			af= mapping.findForward("page2");
		}
		return af;*/
		//动态创建ActionForward
		ActionForward af=new ActionForward();
		af.setPath("/page"+page+".jsp");
		return af;
	}

}
