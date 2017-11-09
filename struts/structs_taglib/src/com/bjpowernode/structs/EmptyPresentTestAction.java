package com.bjpowernode.structs;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EmptyPresentTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("attr1", null);
		request.setAttribute("attr2", "");
		request.setAttribute("attr3",new ArrayList());
		return mapping.findForward("success");
//		return super.execute(mapping, form, request, response);
	}

}
