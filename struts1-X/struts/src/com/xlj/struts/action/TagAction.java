package com.xlj.struts.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.bean.Person;
import com.xlj.dao.PersonDao;
import com.xlj.struts.form.TagForm;

public class TagAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TagForm tagForm=(TagForm)form;
		tagForm.setCheckbox("����");
		tagForm.setMultibox(new String[]{"ѡ��һ","ѡ���"});
		tagForm.setHidden("���ص��ı���");
		tagForm.setPassword("����������");
		tagForm.setRadio("Ů");
		tagForm.setSelect("ѡ���");
		tagForm.setText("�������ı���");
		tagForm.setTextarea("������һ���ı�\r\n���ǵڶ���");
		PersonDao personDao=new PersonDao();
		Connection conn=getDataSource(request).getConnection();
		List<Person> personList=personDao.listPersons(conn);
		request.setAttribute("personList", personList);
		return mapping.getInputForward();
	}

}
