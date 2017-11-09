package com.xlj.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.bean.Person;
import com.xlj.dao.PersonDao;
import com.xlj.struts.form.TileForm;

public class TileAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TileForm tileForm=(TileForm)form;
		if("add".equals(tileForm.getAction())){
			Person person=tileForm.getPerson();
			PersonDao personDao=new PersonDao();
			personDao.addPerson(getDataSource(request).getConnection(), person);
			return mapping.findForward("success");
		}
		return mapping.getInputForward();
	}
	
}
