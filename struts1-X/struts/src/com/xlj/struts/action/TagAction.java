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
		tagForm.setCheckbox("音乐");
		tagForm.setMultibox(new String[]{"选项一","选项二"});
		tagForm.setHidden("隐藏的文本域");
		tagForm.setPassword("这里是密码");
		tagForm.setRadio("女");
		tagForm.setSelect("选项二");
		tagForm.setText("这里是文本域");
		tagForm.setTextarea("这里是一段文本\r\n这是第二行");
		PersonDao personDao=new PersonDao();
		Connection conn=getDataSource(request).getConnection();
		List<Person> personList=personDao.listPersons(conn);
		request.setAttribute("personList", personList);
		return mapping.getInputForward();
	}

}
