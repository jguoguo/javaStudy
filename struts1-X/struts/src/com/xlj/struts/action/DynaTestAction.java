package com.xlj.struts.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class DynaTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm dynaTestForm=(DynaActionForm)form;
		String name=(String)dynaTestForm.get("name");
		Integer age=(Integer)dynaTestForm.get("age");
		Date birthday=(Date)dynaTestForm.get("birthday");
		return mapping.getInputForward();
	}

}
